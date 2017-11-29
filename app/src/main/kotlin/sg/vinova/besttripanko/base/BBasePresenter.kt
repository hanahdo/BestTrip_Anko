package sg.vinova.besttripanko.base

import android.content.Context
import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.WeakReference

/**
 * Created by Hanah on 11/29/2017.
 */
open class BBasePresenter<T>(context: Context) {
    var weakReference: WeakReference<T>? = null
    var requestSubscriptions: CompositeDisposable? = null

    fun bind(t: T) {
        weakReference = WeakReference(t)
        requestSubscriptions = CompositeDisposable()
    }

    fun unbind() {
        if (requestSubscriptions == null) return
        requestSubscriptions!!.clear()
        requestSubscriptions!!.dispose()
    }
}