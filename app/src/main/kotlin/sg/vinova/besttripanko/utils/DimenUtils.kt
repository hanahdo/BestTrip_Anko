package sg.vinova.besttripanko.utils

import android.util.DisplayMetrics

/**
 * Created by Hanah on 11/29/2017.
 */
object DimenUtils {
    fun spToPx(sp: Float, displayMetrics: DisplayMetrics): Float =
            sp * displayMetrics.scaledDensity

    fun pxToSp(px: Float, displayMetrics: DisplayMetrics): Float =
            px / displayMetrics.scaledDensity

    fun dpToPx(dp: Float, displayMetrics: DisplayMetrics): Float =
            dp * displayMetrics.density

    fun pxToDp(px: Float, displayMetrics: DisplayMetrics): Float =
            px / displayMetrics.density
}