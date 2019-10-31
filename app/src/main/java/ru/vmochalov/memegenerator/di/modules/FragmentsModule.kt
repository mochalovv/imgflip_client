package ru.vmochalov.memegenerator.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultScreen

/**
 * Created by Vladimir Mochalov on 27.10.2019.
 */

@Module
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeImageSelectionFragment(): ImageSelectionScreen

    @ContributesAndroidInjector
    abstract fun contributesLabelsFragment(): LabelsScreen

    @ContributesAndroidInjector
    abstract fun contributesResultFragment(): ResultScreen

}