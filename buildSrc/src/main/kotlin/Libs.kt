/**
 * Created by Vladimir Mochalov on 21.09.2019.
 */
object Libs {
    const val androidGradlePlugin = "com.android.tools.build:gradle:3.5.0"

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:1.1.0"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.0.0-beta2"

        const val recyclerview = "androidx.recyclerview:recyclerview:1.0.0"

        const val core = "androidx.core:core-ktx:1.1.0"

        object Test {
            const val espressoCore = "androidx.test.espresso:espresso-core:3.2.0"
            const val runner = "androidx.test:runner:1.2.0"
            const val instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    object Kotlin {
        private const val version = "1.3.50"
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object OkHttp {
        const val okhttp = "com.squareup.okhttp3:okhttp:4.2.0"
    }

    object Retrofit {
        private const val version = "2.5.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
        const val converterScalars = "com.squareup.retrofit2:converter-scalars:$version"
        const val adapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:$version"

        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.10.0"


//        const val
//        // Networking
//        implementation "com.squareup.retrofit2:retrofit:$retrofitVersion"
//        implementation "com.squareup.retrofit2:converter-moshi:$retrofitVersion"
//        implementation "com.squareup.retrofit2:converter-scalars:$retrofitVersion"
//        implementation "com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion"
//        implementation "com.squareup.okhttp3:logging-interceptor:3.10.0"
//

    }

//    const val RETROFIT = "com.squareup.retrofit2:retrofit:${LibraryVersion.RETROFIT}"
//    const val RETROFIT_MOSHI_CONVERTER = "com.squareup.retrofit2:converter-moshi:${LibraryVersion.RETROFIT}"
//    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${LibraryVersion.LOGGING_INTERCEPTOR}"

    object Moshi {
        private const val version = "1.6.0"

        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:$version"
        const val moshiAdapters = "com.squareup.moshi:moshi-adapters:$version"
//        const val moshiKotlin
        // Json
//        implementation "com.squareup.moshi:moshi-kotlin:1.6.0"
//        implementation "com.squareup.moshi:moshi-adapters:1.6.0"

    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
    }

    object Dagger {
        private const val version = "2.24"

        const val dagger = "com.google.dagger:dagger:$version"

//        val daggerAndroid = "com.google.dagger:dagger-android:$version"
//        val daggerAndroidSupport =
//            "com.google.dagger:dagger-android-support:$version" // if you use the support libraries

        const val annotationProcessor =
            "com.google.dagger:dagger-android-processor:$version" //annotationProcessor 'com.google.dagger:dagger-android-processor:2.x'
    }

    object JUnit {
        const val junit = "junit:junit:4.12"
    }

}