package ru.mobileup.leenk.data.system

import ru.mobileup.leenk.extension.context
import ru.mobileup.leenk.extension.module
import ru.mobileup.leenk.extension.single

object SystemModule {

    fun create() = module {
        single { ResourceHelper(context) }
    }
}