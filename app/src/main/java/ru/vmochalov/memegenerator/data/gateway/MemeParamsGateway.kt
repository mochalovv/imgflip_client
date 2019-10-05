package ru.vmochalov.memegenerator.data.gateway

import io.reactivex.Completable
import ru.vmochalov.memegenerator.data.storage.MemeParamsStorage
import ru.vmochalov.memegenerator.domain.meme.MemeParams
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class MemeParamsGateway(
    private val memeParamsStorage: MemeParamsStorage
) {

    init {
        clearMemeParamsGateway()
    }

    fun clearMemeParamsGateway() {
        memeParamsStorage.set(MemeParams.EMPTY_MEME_PARAMS)
    }

    fun setTemplate(template: MemeTemplate): Completable {
        return memeParamsStorage.get()
            .firstOrError()
            .map {
                it.copy(template = template)
            }
            .doOnSuccess {
                memeParamsStorage.set(it)
            }
            .ignoreElement()
    }

    fun setLabels(firstLabel: String, secondLabel: String): Completable {
        return memeParamsStorage.get()
            .firstOrError()
            .map {
                it.copy(
                    text0 = firstLabel,
                    text1 = secondLabel
                )
            }
            .doOnSuccess {
                memeParamsStorage.set(it)
            }
            .ignoreElement()
    }

    fun getMemeParams() = memeParamsStorage.get()
}