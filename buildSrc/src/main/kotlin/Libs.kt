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
        private val version = "1.3.50"
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$version"
        val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object JUnit {
        val junit = "junit:junit:4.12"
    }

}