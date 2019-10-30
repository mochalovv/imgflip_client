package ru.vmochalov.memegenerator.di.modules

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
//import ru.vmochalov.memegenerator.di.component.ImageSelectionSubcomponent
//import ru.vmochalov.memegenerator.di.component.LabelsScreenSubcomponent
//import ru.vmochalov.memegenerator.di.component.ResultScreenSubcomponent
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultScreen

/**
 * Created by Vladimir Mochalov on 27.10.2019.
 */

@Module //(subcomponents = [ImageSelectionSubcomponent::class])
abstract class FragmentsModule {

    @ContributesAndroidInjector
    abstract fun contributeImageSelectionFragment(): ImageSelectionScreen

    @ContributesAndroidInjector
    abstract fun contributesLabelsFragment() : LabelsScreen

    @ContributesAndroidInjector
    abstract fun contributesResultFragment(): ResultScreen
//
//    @ContributesAndroidInjector
//    abstract fun contributeMainActivity(): MainActivity
}

//@Module(subcomponents = [ImageSelectionSubcomponent::class])
//abstract class ImageSelectionScreenModule {
//
//    @Binds
//    @IntoMap
//    @ClassKey(ImageSelectionScreen::class)
//    abstract fun bindImageSelectionScreenInjectorFactory(factory: ImageSelectionSubcomponent.Factory): AndroidInjector.Factory<out Any>
//
//
//}
//
//@Module(subcomponents = [LabelsScreenSubcomponent::class])
//abstract class LabelsScreenModule {
//    @Binds
//    @IntoMap
//    @ClassKey(LabelsScreen::class)
//    abstract fun bindLabelsScreenInjectorFactory(factory: LabelsScreenSubcomponent.Factory): AndroidInjector.Factory<out Any>
//
//}
//
//@Module(subcomponents = [ResultScreenSubcomponent::class])
//abstract class ResultScreenModule {
//    @Binds
//    @IntoMap
//    @ClassKey(ResultScreen::class)
//    abstract fun bindResultScreenInjectorFactory(factory: ResultScreenSubcomponent.Factory): AndroidInjector.Factory<out Any>
//
//}

