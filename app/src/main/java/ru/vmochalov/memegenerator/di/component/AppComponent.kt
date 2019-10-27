package ru.vmochalov.memegenerator.di.component

import android.app.Application
import android.content.Context
import dagger.Component
import ru.vmochalov.memegenerator.data.network.ServerApi
import ru.vmochalov.memegenerator.di.modules.AppModule
import ru.vmochalov.memegenerator.di.modules.NetworkModule
import ru.vmochalov.memegenerator.di.modules.SubcomponentsModule
import javax.inject.Singleton

/**
 * Created by Vladimir Mochalov on 20.10.2019.
 */
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        SubcomponentsModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(application: Application)

    fun mainActivityComponent(): MainActivityComponent.Factory

    fun serverApi(): ServerApi

    fun context(): Context
}