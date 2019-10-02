package temp

import android.app.Application
import org.koin.android.ext.android.startKoin
import ru.mobileup.leenk.allModules
import ru.vmochalov.memegenerator.BuildConfig
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