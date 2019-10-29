package ru.vmochalov.memegenerator.di.component

import android.content.Context
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.vmochalov.memegenerator.TheApplication
import ru.vmochalov.memegenerator.data.network.ServerApi
import ru.vmochalov.memegenerator.di.modules.ActivitiesModule
import ru.vmochalov.memegenerator.di.modules.AppModule
import ru.vmochalov.memegenerator.di.modules.NetworkModule
import ru.vmochalov.memegenerator.di.modules.SubcomponentsModule
import javax.inject.Singleton

/**
 * Created by Vladimir Mochalov on 20.10.2019.
 */
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        NetworkModule::class,
        SubcomponentsModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<TheApplication> { //}: AndroidInjector<TheApplication> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<TheApplication> {
        override fun create(instance: TheApplication?): AndroidInjector<TheApplication> {
            //todo: continue implementing
            return
        }
    }
//    {
//
//    }

//    fun inject(application: TheApplication)

//    fun mainActivityComponent(): MainActivityComponent.Factory

    fun serverApi(): ServerApi

    fun context(): Context
}