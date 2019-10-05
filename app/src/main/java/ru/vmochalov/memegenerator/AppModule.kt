package ru.vmochalov.memegenerator

import ru.vmochalov.memegenerator.data.MoshiFactory
import ru.vmochalov.memegenerator.extension.module
import ru.vmochalov.memegenerator.extension.single

object AppModule {

    fun create() = module {
        factory { KoinHelper() }
        single { MoshiFactory().create() }
    }

}