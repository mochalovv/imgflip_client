package ru.vmochalov.memegenerator.data.gateway

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vmochalov.memegenerator.data.network.ServerApi
import ru.vmochalov.memegenerator.data.network.dto.Ip
import ru.vmochalov.memegenerator.data.network.dto.toGeneratedMeme
import ru.vmochalov.memegenerator.data.network.dto.toIp
import ru.vmochalov.memegenerator.data.network.dto.toMemeTemplate
import ru.vmochalov.memegenerator.data.network.request.CaptionImageRequest
import ru.vmochalov.memegenerator.data.storage.MemeTemplatesStorage
import ru.vmochalov.memegenerator.domain.meme.GeneratedMeme
import ru.vmochalov.memegenerator.domain.meme.MemeParams
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate


class MemesGateway(
    private val api: ServerApi,
    private val memeTemplatesStorage: MemeTemplatesStorage
) {

    fun getMemeTemplates(): Single<List<MemeTemplate>> {
        val cachedMemeTemplates = memeTemplatesStorage.getValueOrNull()

        return if (cachedMemeTemplates?.isNotEmpty() == true) {
            Single.just(cachedMemeTemplates)
        } else {
            loadMemeTemplates()
                .doOnSuccess {
                    memeTemplatesStorage.set(it)
                }
        }
    }

    private fun loadMemeTemplates(): Single<List<MemeTemplate>> {
        return api.getMemes()
            .map { it.data?.memes?.map { it.toMemeTemplate() } ?: emptyList() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun captionImage(
        username: String,
        password: String,
        memeParams: MemeParams
    ): Single<GeneratedMeme> {
        return api
            .captionImage(
                CaptionImageRequest(
                    memeParams.templateId,
                    username,
                    password,
                    memeParams.text0,
                    memeParams.text1,
                    memeParams.font
                )
            )
            .map { it.data?.toGeneratedMeme()!! }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getAnythingIp(): Single<ru.vmochalov.memegenerator.domain.ipreverse.Ip> =
        api.getAnything()
            .map { response ->
                val serverIp = response.ip.substring(0, response.ip.indexOf(","))
                Ip(serverIp).toIp()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}