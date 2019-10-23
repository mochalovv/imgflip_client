package ru.vmochalov.memegenerator.di.component

import android.app.Application
import android.content.Context
import com.squareup.moshi.Moshi
import dagger.Component
import okhttp3.OkHttpClient
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.data.gateway.MemesGateway
import ru.vmochalov.memegenerator.data.network.ServerApi
import ru.vmochalov.memegenerator.data.storage.MemeParamsStorage
import ru.vmochalov.memegenerator.data.storage.MemeTemplatesStorage
import ru.vmochalov.memegenerator.data.system.ClipboardHelper
import ru.vmochalov.memegenerator.data.system.ImageDownloadHelper
import ru.vmochalov.memegenerator.data.system.PermissionsHelper
import ru.vmochalov.memegenerator.data.system.ResourceHelper
import ru.vmochalov.memegenerator.di.*
import ru.vmochalov.memegenerator.domain.SaveMemeToGalleryInteractor
import ru.vmochalov.memegenerator.domain.meme.GenerateMemeInteractor
import ru.vmochalov.memegenerator.domain.meme.LoadMemeTemplatesInteractor
import ru.vmochalov.memegenerator.domain.memeparams.ClearMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.GetMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SelectMemeTemplateInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SetMemeLabelsInteractor
import javax.inject.Singleton

/**
 * Created by Vladimir Mochalov on 20.10.2019.
 */
@Component(
    modules = [
        AppModule::class,
        GatewayModule::class,
        NetworkModule::class,
        StorageModule::class,
        SystemModule::class,
        InteractorModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(application: Application)

    fun memeTemplatesStorage(): MemeTemplatesStorage

    fun memParamsStorage(): MemeParamsStorage

    fun resourceHelper(): ResourceHelper

    fun clipboardHelper(): ClipboardHelper

    fun permissionHelper(): PermissionsHelper

    fun imageDownloadHelper(): ImageDownloadHelper

    fun moshi(): Moshi

    fun serverApi(): ServerApi

    fun okHttpClient(): OkHttpClient

    fun memesGateway(): MemesGateway

    fun memeParamsGateway(): MemeParamsGateway

    fun context(): Context

    fun loadMemeTemplatesInteractor(): LoadMemeTemplatesInteractor

    fun clearMemeParamsInteractor(): ClearMemeParamsInteractor

    fun generateMemeInteractor(): GenerateMemeInteractor

    fun selectMemeTemplateInteractor(): SelectMemeTemplateInteractor

    fun getMemeParamsInteractor(): GetMemeParamsInteractor

    fun setMemeLabelsInteractor(): SetMemeLabelsInteractor

    fun saveMemeToGalleryInteractor(): SaveMemeToGalleryInteractor

}