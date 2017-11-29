package sg.vinova.besttripanko.widgets

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.ViewManager
import android.widget.TextView
import org.jetbrains.anko.custom.ankoView
import sg.vinova.besttripanko.constants.Constant
import java.util.*

/**
 * Created by Hanah on 11/29/2017.
 */
class BTextView : TextView {
    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    public var bFont: String = Constant.TextType.Regular

    private fun init() {
        typeface = Typeface.createFromAsset(context.assets, String.format(Locale.US, "fonts/%s", bFont))
    }
}

@Suppress("NOTHING_TO_INLINE")
inline fun ViewManager.bTextView(theme: Int = 0) = bTextView(
        init = {},
        theme = theme
)

inline fun ViewManager.bTextView(init: BTextView.() -> Unit, theme: Int = 0) = ankoView(::BTextView, theme, init)