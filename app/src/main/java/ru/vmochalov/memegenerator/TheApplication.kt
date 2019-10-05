package ru.vmochalov.memegenerator

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class TheApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initLogging()
    }

    private fun initKoin() {
        startKoin(this, allModules())
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}