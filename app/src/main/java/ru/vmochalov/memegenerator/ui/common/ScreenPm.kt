package ru.vmochalov.memegenerator.ui.common

import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.navigation.NavigationMessage
import ru.vmochalov.memegenerator.ui.Back


abstract class ScreenPm : PresentationModel() {

    val backAction = Action<Unit>()

    override fun onCreate() {
        super.onCreate()

        backAction.observable
            .subscribe { sendNavigationMessage(Back()) }
            .untilDestroy()
    }

    protected fun sendNavigationMessage(message: NavigationMessage) {
        navigationMessages.consumer.accept(message)
    }
}