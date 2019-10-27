package ru.vmochalov.memegenerator

import android.app.Application
import ru.vmochalov.memegenerator.di.component.DaggerAppComponent
import ru.vmochalov.memegenerator.di.modules.AppModule
import timber.log.Timber

class TheApplication : Application() {

    val appComponent = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .build()

    override fun onCreate() {
        super.onCreate()

        initLogging()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}