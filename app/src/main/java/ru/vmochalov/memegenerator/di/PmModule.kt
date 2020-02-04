package ru.vmochalov.memegenerator.di

import org.koin.dsl.module
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionPm
import ru.vmochalov.memegenerator.ui.labels.LabelsPm
import ru.vmochalov.memegenerator.ui.result.ResultPm

object PmModule {

    fun create() = module {
        factory { ImageSelectionPm(get(), get(), get(), get()) }
        factory { LabelsPm(get(), get()) }
        factory { ResultPm(get(), get(), get(), get()) }
    }
}