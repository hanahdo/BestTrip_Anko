package sg.vinova.besttripanko

import android.app.Application

/**
 * Created by Hanah on 11/29/2017.
 */
class BApplication : Application() {

    lateinit var component: BComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        component = DaggerBComponent.builder()
                .bModule(BModule(this)).build()
        component.inject(this)
    }

    companion object {
        lateinit var instance: BApplication
    }

}