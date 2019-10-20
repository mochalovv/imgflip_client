package ru.vmochalov.memegenerator.di

import dagger.Module
import dagger.Provides
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.data.gateway.MemesGateway
import ru.vmochalov.memegenerator.data.system.ImageDownloadHelper
import ru.vmochalov.memegenerator.data.system.PermissionsHelper
import ru.vmochalov.memegenerator.data.system.ResourceHelper
import ru.vmochalov.memegenerator.domain.SaveMemeToGalleryInteractor
import ru.vmochalov.memegenerator.domain.meme.GenerateMemeInteractor
import ru.vmochalov.memegenerator.domain.meme.LoadMemeTemplatesInteractor
import ru.vmochalov.memegenerator.domain.memeparams.ClearMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.GetMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SelectMemeTemplateInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SetMemeLabelsInteractor

@Module
class InteractorModule {

    @Provides
    fun providesLoadMemeTemplatesInteractor(memesGateway: MemesGateway): LoadMemeTemplatesInteractor {
        return LoadMemeTemplatesInteractor(memesGateway)
    }

    @Provides
    fun providesClearMemeParamsInteractor(memeParamsGateway: MemeParamsGateway): ClearMemeParamsInteractor {
        return ClearMemeParamsInteractor(memeParamsGateway)
    }

    @Provides
    fun providesGemerateMemeInteractor(
        memeParamsGateway: MemeParamsGateway,
        memesGateway: MemesGateway
    ): GenerateMemeInteractor {
        return GenerateMemeInteractor(memeParamsGateway, memesGateway)
    }

    @Provides
    fun providesSelectMemeTemplateInteractor(memeParamsGateway: MemeParamsGateway): SelectMemeTemplateInteractor {
        return SelectMemeTemplateInteractor(memeParamsGateway)
    }

    @Provides
    fun providesGetMemeParamsInteractor(memeParamsGateway: MemeParamsGateway): GetMemeParamsInteractor {
        return GetMemeParamsInteractor(memeParamsGateway)
    }

    @Provides
    fun providesSetMemeLabelsInteractor(memeParamsGateway: MemeParamsGateway): SetMemeLabelsInteractor {
        return SetMemeLabelsInteractor(memeParamsGateway)
    }

    @Provides
    fun providesSaveMemeToGalleryInteractor(
        permissionsHelper: PermissionsHelper,
        imageDownloadHelper: ImageDownloadHelper,
        resourceHelper: ResourceHelper
    ): SaveMemeToGalleryInteractor {
        return SaveMemeToGalleryInteractor(
            permissionsHelper,
            imageDownloadHelper,
            resourceHelper
        )
    }
}