package ru.mobileup.leenk.domain

import ru.mobileup.leenk.domain.ipreverse.GetReversedIpInteractor
import ru.mobileup.leenk.extension.module
import temp.domain.meme.GenerateMemeInteractor
import temp.domain.meme.LoadMemeTemplatesInteractor
import temp.domain.meme.SelectMemeTemplateInteractor

object InteractorModule {

    fun create() = module {
        factory { GetReversedIpInteractor(get()) }
        factory { LoadMemeTemplatesInteractor(get()) }
        factory { GenerateMemeInteractor(get()) }
        factory { SelectMemeTemplateInteractor() }
    }
}