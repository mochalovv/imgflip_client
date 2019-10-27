package ru.vmochalov.memegenerator.data.gateway

import io.reactivex.Completable
import ru.vmochalov.memegenerator.data.storage.MemeParamsStorage
import ru.vmochalov.memegenerator.domain.meme.MemeParams
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
@Singleton
class MemeParamsGateway @Inject constructor(
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

    fun setLabels(labels: List<String>): Completable {
        return memeParamsStorage.get()
            .firstOrError()
            .map {
                it.copy(
                    labels = labels
                )
            }
            .doOnSuccess {
                memeParamsStorage.set(it)
            }
            .ignoreElement()
    }

    fun getMemeParams() = memeParamsStorage.get()
}