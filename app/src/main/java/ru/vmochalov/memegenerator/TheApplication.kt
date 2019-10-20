package ru.vmochalov.memegenerator

//import ru.vmochalov.memegenerator.di.component.DaggerAppComponent
//import org.koin.android.ext.koin.androidContext
//import org.koin.core.context.startKoin
//import ru.vmochalov.memegenerator.di.allModules
import android.app.Application
import ru.vmochalov.memegenerator.di.AppModule
import ru.vmochalov.memegenerator.di.component.AppComponent
import ru.vmochalov.memegenerator.di.component.DaggerAppComponent
import timber.log.Timber

class TheApplication : Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

//        DaggerAppComponent.builder().appModule()
//        initKoin()
        initLogging()

        initDagger()
    }

//    private fun initKoin() {
//        startKoin {
//            androidContext(this@TheApplication)
//            modules(allModules())
//        }
//    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDagger() {
        appComponent.inject(this)
    }

}