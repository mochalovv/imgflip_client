package ru.mobileup.leenk.ui.main

import ru.mobileup.leenk.ui.OpenTemplateSelectionScreen
import ru.mobileup.leenk.ui.common.ScreenPm

class MainPm : ScreenPm() {

    override fun onCreate() {
        super.onCreate()

        sendNavigationMessage(OpenTemplateSelectionScreen())
//        sendNavigationMessage(OpenAnythingScreen(777))
    }
}