package ru.vmochalov.memegenerator.data.gateway

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.vmochalov.memegenerator.BuildConfig
import ru.vmochalov.memegenerator.data.network.ServerApi
import ru.vmochalov.memegenerator.data.network.dto.toGeneratedMeme
import ru.vmochalov.memegenerator.data.network.dto.toMemeTemplate
import ru.vmochalov.memegenerator.data.storage.MemeTemplatesStorage
import ru.vmochalov.memegenerator.domain.meme.GeneratedMeme
import ru.vmochalov.memegenerator.domain.meme.MemeParams
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate


class MemesGateway(
    private val api: ServerApi,
    private val memeTemplatesStorage: MemeTemplatesStorage
) {

    companion object {
        private const val BOXES_WITH_TEXT_PARAMETER_TEMPLATE = "boxes[%d][text]"
    }

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
        memeParams: MemeParams
    ): Single<GeneratedMeme> {
        return if (memeParams.template == null) {
            Single.error<GeneratedMeme>(Exception("Meme template id is not set"))
        } else {
            val boxes = memeParams.labels
                .mapIndexed { index, label ->
                    String.format(BOXES_WITH_TEXT_PARAMETER_TEMPLATE, index) to label
                }
                .toMap()

            api
                .captionImage(
                    BuildConfig.API_LOGIN,
                    BuildConfig.API_PASSWORD,
                    memeParams.template.id,
                    boxes
                )
                .map { it.data?.toGeneratedMeme()!! }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}