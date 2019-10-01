package ru.mobileup.leenk.data.gateway

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.mobileup.leenk.data.network.ServerApi
import ru.mobileup.leenk.data.network.dto.Ip
import ru.mobileup.leenk.data.network.dto.toGeneratedMeme
import ru.mobileup.leenk.data.network.dto.toIp
import ru.mobileup.leenk.data.network.dto.toMemeTemplate
import temp.data.network.request.CaptionImageRequest
import temp.data.storage.MemeTemplatesStorage
import temp.domain.meme.GeneratedMeme
import temp.domain.meme.MemeParams
import temp.domain.meme.MemeTemplate


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

    fun getAnythingIp(): Single<ru.mobileup.leenk.domain.ipreverse.Ip> =
        api.getAnything()
            .map { response ->
                val serverIp = response.ip.substring(0, response.ip.indexOf(","))
                Ip(serverIp).toIp()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}