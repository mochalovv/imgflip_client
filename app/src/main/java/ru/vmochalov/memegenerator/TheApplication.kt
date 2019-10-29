package ru.vmochalov.memegenerator

import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import ru.vmochalov.memegenerator.di.component.DaggerAppComponent
//import ru.vmochalov.memegenerator.di.component.DaggerAppComponent
import ru.vmochalov.memegenerator.di.modules.AppModule
import ru.vmochalov.memegenerator.di.modules.NetworkModule
import timber.log.Timber
import javax.inject.Inject

class TheApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        DaggerAppComponent.builder().appModule(AppModule(this)).networkModule(NetworkModule())
            .build().inject(this)

        super.onCreate()

        initLogging()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}