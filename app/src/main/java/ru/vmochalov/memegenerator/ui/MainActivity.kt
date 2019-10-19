package ru.vmochalov.memegenerator.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import me.dmdev.rxpm.navigation.NavigationMessage
import me.dmdev.rxpm.navigation.NavigationMessageHandler
import org.koin.android.ext.android.inject
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.data.system.PermissionsHelper
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultScreen

class MainActivity : AppCompatActivity(), NavigationMessageHandler {

    private lateinit var navigator: FragmentNavigator

    private val permissionHelper by inject<PermissionsHelper>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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