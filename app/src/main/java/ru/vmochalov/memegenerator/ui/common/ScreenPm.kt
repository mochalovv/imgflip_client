package ru.vmochalov.memegenerator.ui.common

import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.action
import me.dmdev.rxpm.command
import me.dmdev.rxpm.navigation.NavigationMessage
import me.dmdev.rxpm.navigation.NavigationalPm
import ru.vmochalov.memegenerator.ui.Back


abstract class ScreenPm : PresentationModel(), NavigationalPm {

    val backAction = action<Unit>()

    override val navigationMessages = command<NavigationMessage>()

    override fun onCreate() {
        super.onCreate()

        backAction.observable
            .map { Back() }
            .subscribe(navigationMessages.consumer)
            .untilDestroy()
    }

    protected fun sendNavigationMessage(message: NavigationMessage) {
        navigationMessages.consumer.accept(message)
    }
}