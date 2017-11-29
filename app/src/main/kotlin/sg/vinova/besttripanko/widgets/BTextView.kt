package sg.vinova.besttripanko.widgets

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.ViewManager
import android.widget.TextView
import org.jetbrains.anko.custom.ankoView
import sg.vinova.besttripanko.R
import sg.vinova.besttripanko.constants.Constant

/**
 * Created by Hanah on 11/29/2017.
 */
class BTextView(context: Context?) : TextView(context) {


    private lateinit var fontFamily: String

    fun bFont(bFont: Constant.TextType) {
        fontFamily = when (bFont) {
            Constant.TextType.Light -> resources.getString(R.string.roboto_light)
            Constant.TextType.Bold -> resources.getString(R.string.roboto_bold)
            Constant.TextType.Medium -> resources.getString(R.string.roboto_medium)
            else -> resources.getString(R.string.roboto_regular)
        }
        typeface = Typeface.createFromAsset(context!!.assets, "fonts/$fontFamily")
    }

    fun bTextColor(textColor: Int) {
        setTextColor(ContextCompat.getColor(context, textColor))
    }

    init {
        if (context != null) {
            typeface = Typeface.createFromAsset(context.assets, "fonts/roboto_regular.ttf")
            setTextColor(ContextCompat.getColor(context, R.color.white))
        }
    }
}

inline fun ViewManager.bTextView(theme: Int = 0) = bTextView(init = {}, theme = theme)

inline fun ViewManager.bTextView(init: BTextView.() -> Unit, theme: Int = 0) = ankoView(::BTextView, theme, init)