package ru.mobileup.leenk.domain

import ru.mobileup.leenk.domain.ipreverse.GetReversedIpInteractor
import ru.mobileup.leenk.extension.module
import ru.mobileup.leenk.extension.single

object InteractorModule {

    fun create() = module {
        single { GetReversedIpInteractor(get()) }
    }
}