package ru.vmochalov.memegenerator.data.storage

import org.koin.dsl.module

object StorageModule {

    fun create() = module {
        single { MemeTemplatesStorage() }
        single { MemeParamsStorage() }
    }
}