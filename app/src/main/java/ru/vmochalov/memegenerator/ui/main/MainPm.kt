package ru.vmochalov.memegenerator.ui.main

import ru.vmochalov.memegenerator.ui.OpenTemplateSelectionScreen
import ru.vmochalov.memegenerator.ui.common.ScreenPm

class MainPm : ScreenPm() {

    override fun onCreate() {
        super.onCreate()

        sendNavigationMessage(OpenTemplateSelectionScreen())
    }
}