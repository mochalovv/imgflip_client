package ru.mobileup.leenk

import ru.mobileup.leenk.data.MoshiFactory
import ru.mobileup.leenk.extension.module
import ru.mobileup.leenk.extension.single

object AppModule {

    fun create() = module {
        factory { KoinHelper() }
        single { MoshiFactory().create() }
    }

}