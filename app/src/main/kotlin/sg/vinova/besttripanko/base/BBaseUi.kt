package sg.vinova.besttripanko.base

import android.view.View
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext

/**
 * Created by Hanah on 11/29/2017.
 */
abstract class BBaseUi<in T> : AnkoComponent<T> {
    override fun createView(ui: AnkoContext<T>): View =
            initView(ui)

    abstract fun initView(ui: AnkoContext<T>): View
}