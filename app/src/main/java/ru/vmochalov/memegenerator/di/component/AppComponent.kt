package ru.vmochalov.memegenerator.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import ru.vmochalov.memegenerator.TheApplication
import ru.vmochalov.memegenerator.data.network.ServerApi
import ru.vmochalov.memegenerator.di.modules.*
import javax.inject.Singleton

/**
 * Created by Vladimir Mochalov on 20.10.2019.
 */
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        AppModule::class,
        NetworkModule::class,
        SubcomponentsModule::class
    ]
)
@Singleton
interface AppComponent { //}: AndroidInjector<TheApplication> { //}: AndroidInjector<TheApplication> {

    fun inject(application: TheApplication)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        fun setAppMdule(appModule: AppModule): Builder

        fun setNetworkModule(networkModule: NetworkModule): Builder

        @BindsInstance
        fun applicationBind(application: TheApplication): Builder
    }
//    @Component.Factory
//    abstract class Factory : AndroidInjector.Factory<TheApplication> {
//        override fun create(instance: TheApplication): AndroidInjector<TheApplication> {
//            //todo: continue implementing
//            return And
//        }
//    }
//    {
//
//    }

//    fun inject(application: TheApplication)

//    fun mainActivityComponent(): MainActivityComponent.Factory

    fun serverApi(): ServerApi

    fun context(): Context
}