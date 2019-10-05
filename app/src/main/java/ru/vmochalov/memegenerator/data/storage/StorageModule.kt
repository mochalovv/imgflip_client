package ru.vmochalov.memegenerator.data.storage

import ru.vmochalov.memegenerator.extension.module
import ru.vmochalov.memegenerator.extension.single

object StorageModule {

    fun create() = module {
        single { MemeTemplatesStorage() }
        single { MemeParamsStorage() }
    }
}