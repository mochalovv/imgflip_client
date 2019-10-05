package ru.vmochalov.memegenerator.ui.main

import me.dmdev.rxpm.navigation.NavigationMessage
import me.dmdev.rxpm.navigation.NavigationMessageHandler
import ru.vmochalov.memegenerator.KoinHelper
import ru.vmochalov.memegenerator.extension.back
import ru.vmochalov.memegenerator.extension.setRoot
import ru.vmochalov.memegenerator.ui.Back
import ru.vmochalov.memegenerator.ui.OpenAnythingScreen
import ru.vmochalov.memegenerator.ui.OpenTemplateSelectionScreen
import ru.vmochalov.memegenerator.ui.anything.AnythingScreen
import ru.vmochalov.memegenerator.ui.common.BasePmActivity
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen

class MainActivity : BasePmActivity<MainPm>(), NavigationMessageHandler {

    override val activityLayout = R.layout.activity_main
    override val containerId = R.id.container

    override val rootScreen = null //AnythingScreen.newInstance(4)

    override fun providePresentationModel() = KoinHelper.get<MainPm>()

    override fun onBindPresentationModel(pm: MainPm) {

    }

    override fun handleNavigationMessage(message: NavigationMessage): Boolean {
        when (message) {
            is OpenAnythingScreen -> router.setRoot(AnythingScreen.newInstance(message.number))

            is OpenTemplateSelectionScreen -> router.setRoot(ImageSelectionScreen())

            is Back -> if (!router.back()) finish()
        }
        return true
    }
}