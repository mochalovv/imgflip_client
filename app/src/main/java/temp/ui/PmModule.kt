package ru.mobileup.leenk.ui

import ru.mobileup.leenk.extension.module
import ru.mobileup.leenk.extension.single
import ru.mobileup.leenk.ui.anything.AnythingPm
import ru.mobileup.leenk.ui.main.MainPm

object PmModule {

    const val ANYTHING_NUMBER = "anything_number" // TODO: Temp

    fun create() = module {
        single { MainPm() }
        single { AnythingPm(getProperty(ANYTHING_NUMBER), get(), get()) }
    }
}