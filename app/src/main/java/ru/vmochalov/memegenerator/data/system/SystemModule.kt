package ru.vmochalov.memegenerator.data.system

import org.koin.dsl.module

object SystemModule {

    fun create() = module {
        single { ResourceHelper(get()) }
        single { ClipboardHelper(get()) }
        single { PermissionsHelper() }
        single { ImageDownloadHelper(get()) }
    }
}