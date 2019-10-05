package ru.vmochalov.memegenerator.domain

import ru.vmochalov.memegenerator.domain.ipreverse.GetReversedIpInteractor
import ru.vmochalov.memegenerator.extension.module
import ru.vmochalov.memegenerator.domain.meme.GenerateMemeInteractor
import ru.vmochalov.memegenerator.domain.meme.LoadMemeTemplatesInteractor
import ru.vmochalov.memegenerator.domain.meme.SelectMemeTemplateInteractor

object InteractorModule {

    fun create() = module {
        factory { GetReversedIpInteractor(get()) }
        factory { LoadMemeTemplatesInteractor(get()) }
        factory { GenerateMemeInteractor(get()) }
        factory { SelectMemeTemplateInteractor() }
    }
}