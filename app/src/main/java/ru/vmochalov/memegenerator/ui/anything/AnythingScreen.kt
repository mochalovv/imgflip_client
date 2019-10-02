package ru.vmochalov.memegenerator.ui.anything

import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.text
import kotlinx.android.synthetic.main.screen_anything.view.*
import ru.vmochalov.memegenerator.KoinHelper
import ru.vmochalov.memegenerator.ui.PmModule
import ru.vmochalov.memegenerator.ui.common.Screen
import ru.vmochalov.memegenerator.R

// TODO: Temp
class AnythingScreen(args: Bundle) : Screen<AnythingPm>(args) {

    companion object {
        private val ARG_NUMBER = "arg_number"

        fun newInstance(number: Int): AnythingScreen {
            return AnythingScreen(
                Bundle().apply {
                    putInt(
                        ARG_NUMBER,
                        number
                    )
                }
            )
        }
    }

    override val screenLayout = R.layout.screen_anything

    override fun providePresentationModel() = KoinHelper.getWithProperties<AnythingPm>(
        PmModule.ANYTHING_NUMBER to args.getInt(ARG_NUMBER)
    )

    override fun onBindPresentationModel(view: View, pm: AnythingPm) {

        pm.ip.observable.bindTo(view.anythingText.text())
        pm.number.observable.bindTo(view.numberText.text())

        view.numberText.clicks().bindTo(pm.numberClicks.consumer)
    }
}