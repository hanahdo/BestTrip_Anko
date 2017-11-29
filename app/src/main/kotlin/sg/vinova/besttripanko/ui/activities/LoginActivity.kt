package sg.vinova.besttripanko.ui.activities

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import sg.vinova.besttripanko.R
import sg.vinova.besttripanko.constants.Constant
import sg.vinova.besttripanko.widgets.bTextView

/**
 * Created by Hanah on 11/29/2017.
 */
class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginActivityUi().setContentView(this)
    }
}

class LoginActivityUi : AnkoComponent<LoginActivity>, AnkoLogger {
    override fun createView(ui: AnkoContext<LoginActivity>): View = with(ui) {
        verticalLayout {
            padding = dip(16)
            backgroundColor = ContextCompat.getColor(context, R.color.background)
            lparams(width = matchParent, height = matchParent)

            bTextView().apply {
                bFont = Constant.TextType.Bold
                text = resources.getString(R.string.app_name)
                lparams(width = matchParent, height = matchParent)
                gravity = Gravity.CENTER
                textSize = 32.toFloat()
                textColor = ContextCompat.getColor(context, R.color.white)
            }
        }
    }

}