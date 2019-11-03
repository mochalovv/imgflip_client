plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

repositories {
    maven(url = "https://jitpack.io")
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

        buildConfigField("String", "API_BASE_URL", "\"https://api.imgflip.com/\"")
        buildConfigField("String", "API_LOGIN", "\"mochalovv\"")
        buildConfigField("String", "API_PASSWORD", "\"Pass_777\"")
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

androidExtensions {
    isExperimental = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Libs.Kotlin.stdlib)

    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.AndroidX.recyclerview)
    implementation(Libs.AndroidX.core)

    implementation("com.google.android.material:material:1.1.0-beta01")

    implementation("io.reactivex.rxjava2:rxkotlin:2.4.0")

    implementation("com.jakewharton.rxbinding2:rxbinding-kotlin:2.1.1")

    implementation("com.jakewharton.rxrelay2:rxrelay:2.1.1")

    // Dagger
    implementation(Libs.Dagger.dagger)
    implementation(Libs.Dagger.daggerAndroidSupport)
    kapt(Libs.Dagger.daggerCompiler)
    kapt(Libs.Dagger.daggerAndroidProcessor)

    // RxPM
    implementation("me.dmdev.rxpm:rxpm:2.0")

    // Images
    implementation("com.github.bumptech.glide:glide:4.10.0")

    // Lists
    implementation("com.hannesdorfmann:adapterdelegates4:4.2.0")

    implementation("androidx.core:core-ktx:1.2.0-beta01")

    // RxPermissions
    implementation("com.github.tbruyelle:rxpermissions:0.10.2")

    implementation(Libs.OkHttp.okhttp)

    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.converterMoshi)
    implementation(Libs.Retrofit.converterScalars)
    implementation(Libs.Retrofit.adapterRxJava)

    implementation(Libs.Retrofit.loggingInterceptor)

    implementation(Libs.Timber.timber)

    implementation(Libs.Moshi.moshiKotlin)
    implementation(Libs.Moshi.moshiAdapters)
}

kapt {
    generateStubs = true
}