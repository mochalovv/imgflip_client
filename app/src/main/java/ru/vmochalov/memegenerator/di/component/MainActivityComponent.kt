package ru.vmochalov.memegenerator.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
//import ru.vmochalov.memegenerator.di.modules.FragmentsModule
import ru.vmochalov.memegenerator.di.modules.ImageSelectionScreenModule
import ru.vmochalov.memegenerator.di.modules.LabelsScreenModule
import ru.vmochalov.memegenerator.di.modules.ResultScreenModule
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.ui.MainActivity
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultScreen

/**
 * Created by Vladimir Mochalov on 19.10.2019.
 */
@MainActivityScope
@Subcomponent(modules = [ImageSelectionScreenModule::class, LabelsScreenModule::class, ResultScreenModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface MainActivityFactory : AndroidInjector.Factory<MainActivity>
//    {
//        fun create(): MainActivityComponent
//    }

    //todo: try to solve errors when compiling
    @Subcomponent.Factory
    interface ImageSelectionScreenFactory : AndroidInjector.Factory<ImageSelectionScreen>
//    fun inject(mainActivity: MainActivity)

//    fun inject(screen: ImageSelectionScreen)

    @Subcomponent.Factory
    interface LabelsScreenFactory : AndroidInjector.Factory<LabelsScreen>
//    fun inject(screen: LabelsScreen)

    @Subcomponent.Factory
    interface ResultScreenFactory : AndroidInjector.Factory<ResultScreen>

//    fun inject(screen: ResultScreen)

}