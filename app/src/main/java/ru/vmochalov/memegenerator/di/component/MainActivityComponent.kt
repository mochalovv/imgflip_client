package ru.vmochalov.memegenerator.di.component

import dagger.Subcomponent
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.ui.MainActivity
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionScreen
import ru.vmochalov.memegenerator.ui.labels.LabelsScreen
import ru.vmochalov.memegenerator.ui.result.ResultScreen

/**
 * Created by Vladimir Mochalov on 19.10.2019.
 */
@Subcomponent
@MainActivityScope
interface MainActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActivityComponent
    }

    fun inject(mainActivity: MainActivity)

    fun inject(screen: ImageSelectionScreen)

    fun inject(screen: LabelsScreen)

    fun inject(screen: ResultScreen)

}