package ru.vmochalov.memegenerator.ui

import ru.vmochalov.memegenerator.extension.module
import ru.vmochalov.memegenerator.extension.single
import ru.vmochalov.memegenerator.ui.anything.AnythingPm
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionPm
import ru.vmochalov.memegenerator.ui.labels.LabelsPm
import ru.vmochalov.memegenerator.ui.main.MainPm
import ru.vmochalov.memegenerator.ui.result.ResultPm

object PmModule {

    const val ANYTHING_NUMBER = "anything_number" // TODO: Temp

    fun create() = module {
        single { MainPm() }
        single {
            AnythingPm(
                getProperty(ANYTHING_NUMBER),
                get(),
                get()
            )
        }
        factory { ImageSelectionPm(get(), get(), get()) }
        factory { LabelsPm(get(), get()) }
        factory { ResultPm(get(), get(), get()) }
    }
}