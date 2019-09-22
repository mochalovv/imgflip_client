package ru.mobileup.leenk.ui.main

import ru.mobileup.leenk.ui.OpenAnythingScreen
import ru.mobileup.leenk.ui.common.ScreenPm

class MainPm : ScreenPm() {

    override fun onCreate() {
        super.onCreate()

        sendNavigationMessage(OpenAnythingScreen(777))
    }
}