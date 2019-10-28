package ru.vmochalov.memegenerator.di.modules

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.vmochalov.memegenerator.di.component.MainActivityComponent
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultScreen

/**
 * Created by Vladimir Mochalov on 27.10.2019.
 */
@Module(subcomponents = [MainActivityComponent::class])
abstract class ImageSelectionScreenModule {

    @Binds
    @IntoMap
    @ClassKey(ImageSelectionScreen::class)
    abstract fun bindImageSelectionScreenInjectorFactory(factory: MainActivityComponent.ImageSelectionScreenFactory): AndroidInjector.Factory<out Any>


}

@Module(subcomponents = [MainActivityComponent::class])
abstract class LabelsScreenModule {
    @Binds
    @IntoMap
    @ClassKey(LabelsScreen::class)
    abstract fun bindLabelsScreenInjectorFactory(factory: MainActivityComponent.LabelsScreenFactory): AndroidInjector.Factory<out Any>

}

@Module(subcomponents = [MainActivityComponent::class])
abstract class ResultScreenModule {
    @Binds
    @IntoMap
    @ClassKey(ResultScreen::class)
    abstract fun bindResultScreenInjectorFactory(factory: MainActivityComponent.ResultScreenFactory): AndroidInjector.Factory<out Any>

}

