/**
 * Created by Vladimir Mochalov on 21.09.2019.
 */
object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.5.0"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta2"

        const val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"

        const val core = "androidx.core:core-ktx:1.2.0-beta01"
    }

    object AndroidMaterial {
        const val material = "com.google.android.material:material:1.1.0-beta01"
    }

    object Rx {
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"

        const val rxBinding = "com.jakewharton.rxbinding2:rxbinding-kotlin:2.1.1"
        const val rxRelay = "com.jakewharton.rxrelay2:rxrelay:2.1.1"
    }

    object Koin {
        const val koinAndroid = "org.koin:koin-android:2.0.1"
    }

    object RxPm {
        const val rxPm = "me.dmdev.rxpm:rxpm:2.0"
    }

    object Kotlin {
        private const val version = "1.3.50"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object OkHttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:4.2.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.10.0"
    }

    object Images {
        const val glide = "com.github.bumptech.glide:glide:4.10.0"
    }

    object Lists {
        const val adapterDelegates = "com.hannesdorfmann:adapterdelegates4:4.2.0"
    }

    object RxPermissions {
        const val rxPermissions = "com.github.tbruyelle:rxpermissions:0.10.2"
    }

    object Retrofit {
        private const val version = "2.5.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
        const val converterScalars = "com.squareup.retrofit2:converter-scalars:$version"
        const val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:$version"
    }

    object Moshi {
        private const val version = "1.6.0"

        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val moshiAdapters = "com.squareup.moshi:moshi-adapters:$version"
    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
    }

}