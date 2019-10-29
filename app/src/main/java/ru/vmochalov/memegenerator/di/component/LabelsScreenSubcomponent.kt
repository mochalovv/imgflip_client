package ru.vmochalov.memegenerator.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen

/**
 * Created by Vladimir Mochalov on 29.10.2019.
 */
//@MainActivityScope
@Subcomponent //(modules = [LabelsScreenModule::class])
interface LabelsScreenSubcomponent : AndroidInjector<LabelsScreen> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<LabelsScreen>
}