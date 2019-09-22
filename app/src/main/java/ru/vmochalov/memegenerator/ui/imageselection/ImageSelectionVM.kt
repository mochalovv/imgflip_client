package ru.vmochalov.memegenerator.ui.imageselection

import androidx.lifecycle.ViewModel

/**
 * Created by Vladimir Mochalov on 15.09.2019.
 */
class ImageSelectionVM : ViewModel() {


    var selectedUrl: String? = null

    var loadedUrls = listOf<String>()

    var nextPicClicks = Unit

    var previousPicClicks = Unit

    var selectLocalImageClicks = Unit


}