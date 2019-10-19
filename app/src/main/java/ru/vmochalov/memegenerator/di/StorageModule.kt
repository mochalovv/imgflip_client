package ru.vmochalov.memegenerator.di

import org.koin.dsl.module
import ru.vmochalov.memegenerator.data.storage.MemeParamsStorage
import ru.vmochalov.memegenerator.data.storage.MemeTemplatesStorage

object StorageModule {

    fun create() = module {
        single { MemeTemplatesStorage() }
        single { MemeParamsStorage() }
    }
}