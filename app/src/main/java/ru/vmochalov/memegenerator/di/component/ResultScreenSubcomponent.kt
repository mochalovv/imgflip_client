package ru.vmochalov.memegenerator.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.ui.result.ResultScreen

/**
 * Created by Vladimir Mochalov on 29.10.2019.
 */
//@MainActivityScope
@Subcomponent //(modules = [ResultScreenModule::class])
interface ResultScreenSubcomponent : AndroidInjector<ResultScreen> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<ResultScreen>

}