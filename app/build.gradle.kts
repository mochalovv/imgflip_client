plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.Build.compileSdkVersion)
    buildToolsVersion = Versions.Build.buildToolsVersion
    defaultConfig {
        applicationId = Versions.Application.id
        minSdkVersion(Versions.Build.minSdkVersions)
        targetSdkVersion(Versions.Build.targetSdkVersion)
        versionCode = Versions.Application.versionCode
        versionName = Versions.Application.versionName
        testInstrumentationRunner = Libs.AndroidX.Test.instrumentationRunner
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.stdlib)

    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.recyclerview)
    implementation(Libs.AndroidX.core)

    implementation("org.koin:koin-android:0.9.3")
    implementation("com.jakewharton.rxbinding2:rxbinding-kotlin:2.1.1")

    // Conductor
    implementation("com.bluelinelabs:conductor:2.1.5")
    implementation("com.bluelinelabs:conductor-support:2.1.5")

    // RxPM
    implementation("me.dmdev.rxpm:rxpm:1.2.3")

    // Images
    implementation("com.github.bumptech.glide:glide:4.6.1")

    // Lists
    implementation("com.hannesdorfmann:adapterdelegates3:3.0.1")


//    implementation(Libs.Dagger.dagger)
//    annotationProcessor(Libs.Dagger.annotationProcessor)

    implementation(Libs.OkHttp.okhttp)

    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.converterMoshi)
    implementation(Libs.Retrofit.converterScalars)
    implementation(Libs.Retrofit.adapterRxJava)

    implementation(Libs.Retrofit.loggingInterceptor)

    implementation(Libs.Timber.timber)

    implementation(Libs.Moshi.moshiKotlin)
    // okhttp 3
    // kotlin ktx

    testImplementation(Libs.JUnit.junit)

    androidTestImplementation(Libs.AndroidX.Test.runner)
    androidTestImplementation(Libs.AndroidX.Test.espressoCore)
}
