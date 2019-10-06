package ru.vmochalov.memegenerator.data.system

import ru.vmochalov.memegenerator.extension.context
import ru.vmochalov.memegenerator.extension.module
import ru.vmochalov.memegenerator.extension.single

object SystemModule {

    fun create() = module {
        single { ResourceHelper(context) }
        single { ClipboardHelper(context) }
        single { PermissionsHelper() }
        single { ImageDownloadHelper(context) }
    }
}