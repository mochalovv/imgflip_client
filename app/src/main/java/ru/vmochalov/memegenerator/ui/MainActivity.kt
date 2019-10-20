package ru.vmochalov.memegenerator.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.dmdev.rxpm.navigation.NavigationMessage
import me.dmdev.rxpm.navigation.NavigationMessageHandler
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.data.system.PermissionsHelper
import ru.vmochalov.memegenerator.di.component.AppComponent
import ru.vmochalov.memegenerator.di.component.DaggerMainActivityComponent
import ru.vmochalov.memegenerator.di.component.MainActivityComponent
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultScreen
import javax.inject.Inject

class MainActivity : AppCompatActivity(), NavigationMessageHandler {

    private lateinit var navigator: FragmentNavigator

    @Inject
    protected lateinit var permissionHelper: PermissionsHelper

//    private val mainActivityComponent : MainActivityComponent by lazy {
//        DaggerMainActivityComponent.builder()
//            .appComponent(AppComponent())
//            .build()
//
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        MainActivityComponent.cre
        setContentView(R.layout.activity_main)

        navigator = FragmentNavigator(
            R.id.container,
            supportFragmentManager,
            this
        )

        if (savedInstanceState == null) {
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