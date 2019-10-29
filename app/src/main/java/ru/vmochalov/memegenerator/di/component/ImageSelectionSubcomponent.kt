package ru.vmochalov.memegenerator.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.vmochalov.memegenerator.di.modules.ImageSelectionScreenModule
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen

/**
 * Created by Vladimir Mochalov on 29.10.2019.
 */
//@MainActivityScope
@Subcomponent //(modules = [ImageSelectionScreenModule::class])
interface ImageSelectionSubcomponent : AndroidInjector<ImageSelectionScreen> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ImageSelectionScreen>
}