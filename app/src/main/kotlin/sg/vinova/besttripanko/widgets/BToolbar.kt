package sg.vinova.besttripanko.widgets

import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.View
import android.view.ViewManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toolbar
import org.jetbrains.anko.backgroundColor
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageView
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.matchParent
import sg.vinova.besttrip.services.BaseListener
import sg.vinova.besttrip.utils.GlideUtils
import sg.vinova.besttripanko.R
import sg.vinova.besttripanko.constants.Constant

/**
 * Created by Hanah on 11/29/2017.
 */
class BToolbar(context: Context?) : Toolbar(context) {

    private lateinit var ivLeft: ImageView
    private lateinit var ivRight: ImageView
    private lateinit var tvTitle: BTextView
    private var listener: BaseListener.OnToolbarClickListener? = null

    init {
        linearLayout {
            lparams(weight = matchParent.toFloat(), height = android.R.attr.actionBarSize)
            orientation = LinearLayout.HORIZONTAL
            backgroundColor = ContextCompat.getColor(context!!, R.color.background)

            ivLeft = imageView().apply {
                lparams(weight = android.R.attr.actionBarSize.toFloat(), height = android.R.attr.actionBarSize)
                visibility = View.INVISIBLE
            }

            tvTitle = bTextView().apply {
                bFont(Constant.TextType.Regular)
            }

            imageView().apply {
                lparams(weight = android.R.attr.actionBarSize.toFloat(), height = android.R.attr.actionBarSize)
                visibility = View.INVISIBLE
            }
        }
    }

    fun setListener(listener: BaseListener.OnToolbarClickListener) {
        this.listener = listener
    }

    fun setToolbarTitle(string: String?) {
        if (string == null) return
        tvTitle.text = string
    }

    fun hideLeftIcon() {
        ivLeft.visibility = View.INVISIBLE
    }

    fun hideRightIcon() {
        ivRight.visibility = View.INVISIBLE
    }

    fun setLeftIcon(drawable: Int) {
        ivLeft.visibility = View.VISIBLE
        GlideUtils.loadImage(drawable, context, ivLeft)
        ivLeft.setOnClickListener({ listener!!.onLeftClick() })
    }

    fun setRightIcon(drawable: Int) {
        ivLeft.visibility = View.VISIBLE
        GlideUtils.loadImage(drawable, context, ivRight)
        ivRight.setOnClickListener({ listener!!.onRightClick() })
    }
}

inline fun ViewManager.bToolbar(theme: Int = 0) = bToolbar(init = {}, theme = theme)

inline fun ViewManager.bToolbar(init: BToolbar.() -> Unit, theme: Int = 0) = ankoView(::BToolbar, theme, init)