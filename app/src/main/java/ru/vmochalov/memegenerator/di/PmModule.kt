package ru.vmochalov.memegenerator.di

import dagger.Module
import dagger.Provides
import ru.vmochalov.memegenerator.data.system.ClipboardHelper
import ru.vmochalov.memegenerator.data.system.ResourceHelper
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

@Module
class PmModule {

    @Provides
    fun providesImageSelectionPm(
        loadMemeTemplatesInteractor: LoadMemeTemplatesInteractor,
        selectMemeTemplateInteractor: SelectMemeTemplateInteractor,
        clearMemeParamsInteractor: ClearMemeParamsInteractor,
        resourceHelper: ResourceHelper
    ): ImageSelectionPm {
        return ImageSelectionPm(
            loadMemeTemplatesInteractor,
            selectMemeTemplateInteractor,
            clearMemeParamsInteractor,
            resourceHelper
        )
    }

    @Provides
    fun providesLabelsPm(
        getMemeParamsInteractor: GetMemeParamsInteractor,
        setMemeLabelsInteractor: SetMemeLabelsInteractor
    ): LabelsPm {
        return LabelsPm(
            getMemeParamsInteractor,
            setMemeLabelsInteractor
        )
    }

    @Provides
    fun providesResultPm(
        generateMemeInteractor: GenerateMemeInteractor,
        clipboardHelper: ClipboardHelper,
        resourceHelper: ResourceHelper,
        saveMemeToGalleryInteractor: SaveMemeToGalleryInteractor
    ): ResultPm {
        return ResultPm(
            generateMemeInteractor,
            clipboardHelper,
            resourceHelper,
            saveMemeToGalleryInteractor
        )
    }

}