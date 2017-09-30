package co.blackfintech.authenticator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import co.blackfintech.authenticator.util.SessionStore
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton

class LoginActivity : AppCompatActivity()
{

  override fun onCreate(savedInstanceState: Bundle?)
  {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_login)

    supportActionBar?.hide()
    loginButton.onClick {

      val email = emailEdit.text.toString()
      val password = passwordEdit.text.toString()

      validate(email, password)
    }
  }

  private fun validate(email: String, password: String)
  {

    if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

      alert("Email not valid", "Error") {
        okButton { return@okButton }
      }.show()
    }

    if (email.isEmpty() || password.isEmpty()) {

      alert("Kompletoha pls.", "Error") {
        okButton {
          return@okButton
        }
      }.show()
    }

    if (email.equals("ong.jp08@gmail.com") && password.equals("12345")) {

      startActivity<MainActivity>()
      val store = SessionStore()
      store.saveEmail(email, this)
      finish()
    } else {
      alert("Mali. lol", "Error") {
        okButton { return@okButton }
      }.show()
    }
  }
}
