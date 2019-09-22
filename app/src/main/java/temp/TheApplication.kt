package ru.mobileup.leenk

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import io.fabric.sdk.android.Fabric
import org.koin.android.ext.android.startKoin
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig


class TheApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initLogging()
        initCalligraphy()
        initFabric()
    }

    private fun initKoin() {
        startKoin(this, allModules())
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    /**
     * Sets default font to the whole application via Calligraphy library
     */
    private fun initCalligraphy() {
        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_main_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
        )
    }

    private fun initFabric() {
        val crashlytics = Crashlytics.Builder()
            .core(CrashlyticsCore.Builder().disabled(!BuildConfig.ENABLE_CRASHLYTICS).build())
            .build()

        Fabric.with(Fabric.with(this, crashlytics))
    }

}