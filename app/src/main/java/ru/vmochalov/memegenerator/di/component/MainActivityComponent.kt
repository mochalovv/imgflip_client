package ru.vmochalov.memegenerator.di.component

import dagger.Component
import ru.vmochalov.memegenerator.di.PmModule
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.ui.MainActivity
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionPm
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsPm
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultPm
import ru.vmochalov.memegenerator.ui.result.ResultScreen

/**
 * Created by Vladimir Mochalov on 19.10.2019.
 */
@Component(
    modules = [
        PmModule::class
    ],
    dependencies = [
        AppComponent::class
    ]
)
@MainActivityScope
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    fun inject(screen: ImageSelectionScreen)

    fun inject(screen: LabelsScreen)

    fun inject(screen: ResultScreen)

    fun imageSelectionPm(): ImageSelectionPm

    fun labelsPm(): LabelsPm

    fun resultPm(): ResultPm

}