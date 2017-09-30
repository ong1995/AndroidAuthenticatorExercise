package co.blackfintech.authenticator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.blackfintech.authenticator.util.SessionStore
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.okButton
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val store = SessionStore()

        logoutButton.onClick {
            alert(R.string.logout_message, R.string.signoff) {
                okButton {
                    store.clearEmail(this@MainActivity)
                    startActivity<LoginActivity>()
                    finish()
                }
            }.show()
        }
    }
}