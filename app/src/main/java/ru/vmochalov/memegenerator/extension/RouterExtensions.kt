package ru.vmochalov.memegenerator.extension

import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

/**
 * Extensions to made navigation easy.
 * @author Dmitriy Gorbunov
 */

fun Router.goTo(
    screen: Controller,
    pushChangeHandler: ControllerChangeHandler? = null,
    popChangeHandler: ControllerChangeHandler? = null
) {

    pushController(
        RouterTransaction.with(screen)
            .tag(screen::class.java.name)
            .apply {
                pushChangeHandler?.let { pushChangeHandler(it) }
                popChangeHandler?.let { popChangeHandler(it) }
            }
    )
}

fun Router.setRoot(screen: Controller) {
    setRoot(
        RouterTransaction.with(screen)
            .tag(screen::class.java.name)
    )
}

fun Router.goToStacked(vararg screens: Controller) {
    setBackstack(
        backstack.plus(
            screens.map { screen ->
                RouterTransaction.with(screen)
                    .tag(screen::class.java.name)
            }
        ),
        null
    )
}

fun Router.back(): Boolean {
    return if (backstackSize > 1) {
        popCurrentController()
        true
    } else {
        false
    }
}

inline fun <reified T : Controller> Router.backTo() {
    if (backstackSize > 1) {
        popToTag(T::class.java.name)
    }
}

inline fun <reified T : Controller> Router.find(): T? {
    return getControllerWithTag(T::class.java.name) as? T
}

fun Router.find(screenInstanceId: String?): Controller? {
    return screenInstanceId?.let { getControllerWithInstanceId(screenInstanceId) }
}

fun Router.currentScreen(): Controller? {
    return if (backstack.isNotEmpty()) {
        backstack.last().controller()
    } else {
        null
    }
}
