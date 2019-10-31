package ru.vmochalov.memegenerator.di.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.ui.MainActivity

/**
 * Created by Vladimir Mochalov on 19.10.2019.
 */
@MainActivityScope
@Subcomponent
interface MainActivityComponent : AndroidInjector<MainActivity> {

    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>

}