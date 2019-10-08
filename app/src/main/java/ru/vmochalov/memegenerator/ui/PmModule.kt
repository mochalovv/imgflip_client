package ru.vmochalov.memegenerator.ui

import ru.vmochalov.memegenerator.extension.module
import ru.vmochalov.memegenerator.extension.single
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionPm
import ru.vmochalov.memegenerator.ui.labels.LabelsPm
import ru.vmochalov.memegenerator.ui.main.MainPm
import ru.vmochalov.memegenerator.ui.result.ResultPm

object PmModule {

    fun create() = module {
        single { MainPm() }
        factory { ImageSelectionPm(get(), get(), get()) }
        factory { LabelsPm(get(), get()) }
        factory { ResultPm(get(), get(), get(), get()) }
    }
}