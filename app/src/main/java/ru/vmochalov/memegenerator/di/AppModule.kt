package ru.vmochalov.memegenerator.di

import org.koin.dsl.module
import ru.vmochalov.memegenerator.data.MoshiFactory

object AppModule {

    fun create() = module {
        single { MoshiFactory().create() }
    }

}