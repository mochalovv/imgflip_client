package ru.vmochalov.memegenerator.ui

import me.dmdev.rxpm.navigation.NavigationMessage

class Back : NavigationMessage

class OpenTemplateSelectionScreen : NavigationMessage

class OpenLabelsScreen : NavigationMessage

class OpenResultScreen : NavigationMessage

class OpenUrl(val url: String) : NavigationMessage