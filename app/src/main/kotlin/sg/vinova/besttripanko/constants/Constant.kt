package sg.vinova.besttripanko.constants

import android.content.res.Resources
import sg.vinova.besttripanko.R

/**
 * Created by Hanah on 11/29/2017.
 */
object Constant {
    const val appName = "BestTrip"

    object TextType {
        val Light = Resources.getSystem().getString(R.string.roboto_light)
        val Bold = Resources.getSystem().getString(R.string.roboto_bold)
        val Medium = Resources.getSystem().getString(R.string.roboto_medium)
        val Regular = Resources.getSystem().getString(R.string.roboto_regular)
    }
}