package ru.vmochalov.memegenerator.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.DaggerAppCompatActivity
import me.dmdev.rxpm.navigation.NavigationMessage
import me.dmdev.rxpm.navigation.NavigationMessageHandler
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.data.system.PermissionsHelper
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultScreen
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationMessageHandler, HasAndroidInjector {

    private lateinit var navigator: FragmentNavigator

    @Inject
    protected lateinit var permissionHelper: PermissionsHelper

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

//    lateinit var mainActivityComponent: MainActivityComponent

    override fun androidInjector(): AndroidInjector<Any> {

//        DaggerAppCompatActivity
        return androidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
//        mainActivityComponent = (application as TheApplication).appComponent
//            .mainActivityComponent()
//            .create()
//            .apply {
//                inject(this@MainActivity)
//            }

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        navigator = FragmentNavigator(
            R.id.container,
            supportFragmentManager,
            this
        )

        if (savedInstanceState == null) {
            val a = 1
            navigator.setRoot(ImageSelectionScreen())
        }

        permissionHelper.attach(this)
    }

    override fun handleNavigationMessage(message: NavigationMessage): Boolean {
        when (message) {
            is OpenTemplateSelectionScreen -> navigator.backToRoot()

            is OpenLabelsScreen -> navigator.goTo(LabelsScreen())

            is OpenResultScreen -> navigator.goTo(ResultScreen())

            is OpenUrl -> {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(message.url)
                    )
                )
            }

            is Back -> navigator.back()
        }
        return true
    }

    override fun onDestroy() {
        permissionHelper.detach()

        super.onDestroy()
    }
}