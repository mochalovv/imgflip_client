package ru.vmochalov.memegenerator.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.vmochalov.memegenerator.ui.MainActivity

/**
 * Created by Vladimir Mochalov on 27.10.2019.
 */
@Module//(subcomponents = [MainActivityComponent::class])
abstract class ActivitiesModule {

//    @Binds
//    @IntoMap
//    @ClassKey(MainActivity::class)
//    abstract fun bindAndroidInjectorFactory(factory: MainActivityComponent.Factory): AndroidInjector.Factory<out Any>

    @ContributesAndroidInjector //(modules = [FragmentsModule::class])
    abstract fun contributeMainActivity(): MainActivity

}