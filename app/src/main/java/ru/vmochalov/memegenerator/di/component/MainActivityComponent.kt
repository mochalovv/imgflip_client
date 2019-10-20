package ru.vmochalov.memegenerator.di.component

import dagger.Component
import ru.vmochalov.memegenerator.di.InteractorModule
import ru.vmochalov.memegenerator.di.PmModule
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.domain.SaveMemeToGalleryInteractor
import ru.vmochalov.memegenerator.domain.meme.GenerateMemeInteractor
import ru.vmochalov.memegenerator.domain.meme.LoadMemeTemplatesInteractor
import ru.vmochalov.memegenerator.domain.memeparams.ClearMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.GetMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SelectMemeTemplateInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SetMemeLabelsInteractor
import ru.vmochalov.memegenerator.ui.imageselection.ImageSelectionPm
import ru.vmochalov.memegenerator.ui.labels.LabelsPm
import ru.vmochalov.memegenerator.ui.result.ResultPm

/**
 * Created by Vladimir Mochalov on 19.10.2019.
 */
@Component(
    modules = [
        InteractorModule::class,
        PmModule::class
    ],
    dependencies = [
        AppComponent::class
    ]
)
@MainActivityScope
interface MainActivityComponent {

//    fun inject()
//    fun inject(mainActivity: MainActivity)

    fun imageSelectionPm(): ImageSelectionPm

    fun labelsPm(): LabelsPm

    fun resultPm(): ResultPm

    fun loadMemeTemplatesInteractor(): LoadMemeTemplatesInteractor

    fun clearMemeParamsInteractor(): ClearMemeParamsInteractor

    fun generateMemeInteractor(): GenerateMemeInteractor

    fun selectMemeTemplateInteractor(): SelectMemeTemplateInteractor

    fun getMemeParamsInteractor(): GetMemeParamsInteractor

    fun setMemeLabelsInteractor(): SetMemeLabelsInteractor

    fun saveMemeToGalleryInteractor(): SaveMemeToGalleryInteractor

}