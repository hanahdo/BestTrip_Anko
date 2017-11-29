package sg.vinova.besttripanko.ui.fragments

import android.support.v4.content.ContextCompat
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.support.v4.UI
import sg.vinova.besttripanko.BApplication
import sg.vinova.besttripanko.R
import sg.vinova.besttripanko.base.BBaseFragment
import sg.vinova.besttripanko.constants.Constant
import sg.vinova.besttripanko.module.SplashPresenter
import sg.vinova.besttripanko.widgets.bTextView
import javax.inject.Inject

/**
 * Created by Hanah on 11/29/2017.
 */
class SplashFragment : BBaseFragment() {

    @Inject lateinit var presenter: SplashPresenter

    companion object {
        fun newInstance(): SplashFragment {
            val fragment = SplashFragment()
            return fragment
        }
    }

    override fun inject() {
        BApplication.instance.component.inject(this)
    }

    override fun init() {
        if (!isAdded) return
    }

    override fun bindPresenter() {
        presenter.bind(this)
    }

    override fun unbindPresenter() {
        presenter.unbind()
    }

    override fun initView(): View =
            UI {
                verticalLayout {
                    id = R.id.layoutContainer
                    padding = dip(16)
                    backgroundColor = ContextCompat.getColor(context!!, R.color.background)
                    lparams(width = matchParent, height = matchParent)

                    bTextView().apply {
                        bFont(Constant.TextType.Bold)
                        text = resources.getString(R.string.app_name)
                        lparams(width = matchParent, height = matchParent)
                        gravity = Gravity.CENTER
                        textSize = 32.toFloat()
                    }
                }
            }.view
}