package ru.vmochalov.memegenerator.ui.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.*
import me.dmdev.rxpm.base.PmController
import me.dmdev.rxpm.navigation.NavigationMessage
import me.dmdev.rxpm.navigation.NavigationMessageHandler


abstract class Screen<PM : ScreenPm>(bundle: Bundle? = null) :
    PmController<PM>(bundle),
    LayoutContainer,
    NavigationMessageHandler {

    protected val context: Context? get() = activity

    // Holds the view to allow the usage of android extensions right after the view is inflated.
    private var internalContainerView: View? = null

    override val containerView: View? get() = internalContainerView

    protected abstract val screenLayout: Int

    override fun createView(
        inflater: LayoutInflater,
        container: ViewGroup,
        savedViewState: Bundle?
    ): View {
        return inflater.inflate(screenLayout, container, false).also {
            internalContainerView = it
            onInitView(it, savedViewState)
        }
    }

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)

        internalContainerView = null
//        clearFil
        clearFindViewByIdCache()
    }

    /**
     * Use for views initialisation.
     */
    protected open fun onInitView(view: View, savedViewState: Bundle?) {
        // Nothing by default
    }

    final override fun onBindPresentationModel(pm: PM) {
        onBindPresentationModel(view!!, pm)
    }

    abstract fun onBindPresentationModel(view: View, pm: PM)

    override fun handleBack(): Boolean {
        passTo(presentationModel.backAction.consumer)
        return true
    }

    override fun handleNavigationMessage(message: NavigationMessage): Boolean {
        return false
    }

}