package sg.vinova.besttripanko.base

import android.content.Intent
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import sg.vinova.besttripanko.R

/**
 * Created by Hanah on 11/29/2017.
 */
abstract class BBaseActivity : AppCompatActivity() {
    abstract fun replaceFragmentId(): Int

    abstract fun init()

    open fun changeFragment(fragment: BBaseFragment, addBackStack: Boolean) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        if (!addBackStack) {
            val fragmentManager: FragmentManager = supportFragmentManager
            val backStackEntryCount: Int = fragmentManager.backStackEntryCount
            for (i: Int in 0 until backStackEntryCount) {
                fragmentManager.popBackStackImmediate()
            }
        }
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left);
        fragmentTransaction.replace(replaceFragmentId(), fragment, fragment.javaClass.simpleName)
        if (addBackStack) {
            fragmentTransaction.addToBackStack(fragment.javaClass.simpleName)
        }
        fragmentTransaction.commitAllowingStateLoss()
    }

    open fun replaceFragment(fragment: BBaseFragment, containerId: Int) {
        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        fragmentTransaction.replace(containerId, fragment, fragment.javaClass.simpleName)
        fragmentTransaction.commitAllowingStateLoss()
    }

    fun changeActivity(cls: Class<*>) {
        val intent = Intent(this, cls)
        startActivity(intent)
        finish()
    }
}