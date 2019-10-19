package ru.vmochalov.memegenerator.ui

import android.app.Activity
import androidx.annotation.IdRes
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class FragmentNavigator(
    @IdRes private val screenContainerId: Int,
    val fm: FragmentManager,
    private val activity: Activity
) {

    private val Fragment.screenTag get() = this::class.java.name

    fun setRoot(fragment: Fragment) {
        fm.beginTransaction()
            .add(screenContainerId, fragment, fragment.screenTag)
            .commitNow()
    }

    fun goTo(fragment: Fragment) {
        fm.beginTransaction()
            .addToBackStack(fragment.screenTag)
            .replace(screenContainerId, fragment, fragment.screenTag)
            .commit()
    }

    fun replace(fragment: Fragment) {
        back()
        goTo(fragment)
    }

    fun back() {
        if (fm.backStackEntryCount > 0) {
            fm.popBackStackImmediate()
        } else {
            activity.finish()
        }
    }

    fun showDialog(fragment: DialogFragment) {
        fragment.show(
            fm.beginTransaction()
                .addToBackStack(fragment.screenTag),
            fragment.screenTag
        )
    }

    inline fun <reified T : Fragment> backTo() {
        fm.popBackStackImmediate(T::class.java.name, 0)
    }

    fun backToRoot() {
        while (fm.backStackEntryCount > 0) {
            fm.popBackStackImmediate()
        }
    }
}