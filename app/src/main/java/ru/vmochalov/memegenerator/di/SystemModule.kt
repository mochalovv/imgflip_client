package ru.vmochalov.memegenerator.di

import org.koin.dsl.module
import ru.vmochalov.memegenerator.data.system.ClipboardHelper
import ru.vmochalov.memegenerator.data.system.ImageDownloadHelper
import ru.vmochalov.memegenerator.data.system.PermissionsHelper
import ru.vmochalov.memegenerator.data.system.ResourceHelper

object SystemModule {

    fun create() = module {
        single { ResourceHelper(get()) }
        single { ClipboardHelper(get()) }
        single { PermissionsHelper() }
        single { ImageDownloadHelper(get()) }
    }
}