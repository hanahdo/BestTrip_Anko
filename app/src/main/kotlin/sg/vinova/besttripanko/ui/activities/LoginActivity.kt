package sg.vinova.besttripanko.ui.activities

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.drawerLayout
import sg.vinova.besttripanko.R
import sg.vinova.besttripanko.base.BBaseActivity
import sg.vinova.besttripanko.base.BBaseUi
import sg.vinova.besttripanko.ui.fragments.SplashFragment
import sg.vinova.besttripanko.widgets.bToolbar

/**
 * Created by Hanah on 11/29/2017.
 */
class LoginActivity : BBaseActivity() {
    override fun replaceFragmentId(): Int = R.id.fragmentContainer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginActivityView().setContentView(this)
        init()
    }

    override fun init() {
//        setActionBar()
        changeFragment(SplashFragment.newInstance(), false)
//        replaceFragment(MenuFragment.newInstance(), R.id.leftContainer)
    }
}

class LoginActivityView : BBaseUi<LoginActivity>() {
    override fun initView(ui: AnkoContext<LoginActivity>): View = ui.apply {
        drawerLayout {
            id = R.id.drawer
            lparams(width = matchParent, height = matchParent)

            linearLayout {
                lparams(width = matchParent, height = matchParent)
                orientation = LinearLayout.VERTICAL

                bToolbar().apply {
                    lparams(weight = matchParent.toFloat(), height = wrapContent)
                    id = R.id.toolbar
                    setContentInsetsRelative(0, 0)
                }

                frameLayout {
                    lparams(width = matchParent, height = matchParent)
                    id = R.id.fragmentContainer
                }

            }
        }
    }.view
}