package ru.vmochalov.memegenerator.domain

import ru.vmochalov.memegenerator.domain.ipreverse.GetReversedIpInteractor
import ru.vmochalov.memegenerator.domain.meme.GenerateMemeInteractor
import ru.vmochalov.memegenerator.domain.meme.LoadMemeTemplatesInteractor
import ru.vmochalov.memegenerator.domain.memeparams.ClearMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.GetMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SelectMemeTemplateInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SetMemeLabelsInteractor
import ru.vmochalov.memegenerator.extension.module

object InteractorModule {

    fun create() = module {
        factory { GetReversedIpInteractor(get()) }
        factory { LoadMemeTemplatesInteractor(get()) }
        factory { ClearMemeParamsInteractor(get()) }
        factory { GenerateMemeInteractor(get(), get()) }
        factory { SelectMemeTemplateInteractor(get()) }
        factory { GetMemeParamsInteractor(get()) }
        factory { SetMemeLabelsInteractor(get()) }
        factory { SaveMemeToGalleryInteractor(get(), get(), get()) }
    }
}