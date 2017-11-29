package sg.vinova.besttripanko.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Hanah on 11/29/2017.
 */
abstract class BBaseFragment : Fragment() {
    abstract fun inject()

    abstract fun init()

    abstract fun bindPresenter()

    abstract fun unbindPresenter()

    abstract fun initView(): View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindPresenter()
        return initView()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        unbindPresenter()
    }
}