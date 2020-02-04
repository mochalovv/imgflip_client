package ru.vmochalov.memegenerator

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.vmochalov.memegenerator.di.allModules
import timber.log.Timber

class TheApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initLogging()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@TheApplication)
            modules(allModules())
        }
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}