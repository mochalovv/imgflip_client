package ru.mobileup.leenk.data.storage

import ru.mobileup.leenk.extension.module
import ru.mobileup.leenk.extension.single
import temp.data.storage.MemeParamsStorage
import temp.data.storage.MemeTemplatesStorage

object StorageModule {

    fun create() = module {
        single { MemeTemplatesStorage() }
        single { MemeParamsStorage() }
    }
}