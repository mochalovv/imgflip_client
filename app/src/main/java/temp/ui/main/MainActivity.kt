package ru.mobileup.leenk.ui.main

import me.dmdev.rxpm.navigation.NavigationMessage
import me.dmdev.rxpm.navigation.NavigationMessageHandler
import ru.mobileup.leenk.KoinHelper
import ru.mobileup.leenk.extension.back
import ru.mobileup.leenk.extension.setRoot
import ru.mobileup.leenk.ui.Back
import ru.mobileup.leenk.ui.OpenAnythingScreen
import ru.mobileup.leenk.ui.OpenTemplateSelectionScreen
import ru.mobileup.leenk.ui.anything.AnythingScreen
import ru.mobileup.leenk.ui.common.BasePmActivity
import ru.vmochalov.memegenerator.R
import temp.ui.imageselection.ImageSelectionScreen

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