plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
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

    implementation(Libs.AndroidMaterial.material)

    implementation(Libs.Rx.rxKotlin)
    implementation(Libs.Rx.rxBinding)
    implementation(Libs.Rx.rxRelay)

    implementation(Libs.Koin.koinAndroid)

    implementation(Libs.RxPm.rxPm)

    implementation(Libs.Images.glide)

    implementation(Libs.Lists.adapterDelegates)

    implementation(Libs.RxPermissions.rxPermissions)

    implementation(Libs.OkHttp.okhttp)
    implementation(Libs.OkHttp.loggingInterceptor)

    implementation(Libs.Retrofit.retrofit)
    implementation(Libs.Retrofit.converterMoshi)
    implementation(Libs.Retrofit.converterScalars)
    implementation(Libs.Retrofit.adapterRxJava)

    implementation(Libs.Timber.timber)

    implementation(Libs.Moshi.moshiKotlin)
    implementation(Libs.Moshi.moshiAdapters)
}
