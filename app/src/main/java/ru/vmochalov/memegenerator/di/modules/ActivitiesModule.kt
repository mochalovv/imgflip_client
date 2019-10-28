package ru.vmochalov.memegenerator.di.modules

import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import ru.vmochalov.memegenerator.di.component.MainActivityComponent
import ru.vmochalov.memegenerator.ui.MainActivity

/**
 * Created by Vladimir Mochalov on 27.10.2019.
 */
@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivitiesModule {

    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindAndroidInjectorFactory(factory: MainActivityComponent.MainActivityFactory): AndroidInjector.Factory<out Any>
}