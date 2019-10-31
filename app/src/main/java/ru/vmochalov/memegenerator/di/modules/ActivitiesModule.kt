package ru.vmochalov.memegenerator.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.ui.MainActivity

/**
 * Created by Vladimir Mochalov on 27.10.2019.
 */
@Module
abstract class ActivitiesModule {

    @MainActivityScope
    @ContributesAndroidInjector(modules = [FragmentsModule::class])
    abstract fun contributeMainActivity(): MainActivity

}