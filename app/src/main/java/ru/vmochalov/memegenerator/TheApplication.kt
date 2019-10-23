package ru.vmochalov.memegenerator

import android.app.Application
import ru.vmochalov.memegenerator.di.*
import ru.vmochalov.memegenerator.di.component.AppComponent
import ru.vmochalov.memegenerator.di.component.DaggerAppComponent
import ru.vmochalov.memegenerator.di.component.DaggerMainActivityComponent
import ru.vmochalov.memegenerator.di.component.MainActivityComponent
import timber.log.Timber

class TheApplication : Application() {

    companion object {
        private lateinit var instance: TheApplication

        fun getInstance() = instance
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .gatewayModule(GatewayModule())
            .networkModule(NetworkModule())
            .storageModule(StorageModule())
            .systemModule(SystemModule())
            .interactorModule(InteractorModule())
            .build()
    }

    private var mainActivityComponent: MainActivityComponent? = null

    fun getMainActivityComponent(): MainActivityComponent {
        return mainActivityComponent ?: DaggerMainActivityComponent
            .builder()
            .appComponent(appComponent)
            .pmModule(PmModule())
            .build()
            .also { mainActivityComponent = it }
    }

    fun clearMainActivityComponent() {
        mainActivityComponent = null
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        initDagger()
        initLogging()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    private fun initDagger() {
        appComponent.inject(this)
    }

}