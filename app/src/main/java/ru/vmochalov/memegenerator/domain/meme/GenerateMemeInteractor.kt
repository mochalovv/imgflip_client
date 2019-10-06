package ru.vmochalov.memegenerator.domain.meme

import io.reactivex.Single
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.data.gateway.MemesGateway

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class GenerateMemeInteractor(
    private val memeParamsGateway: MemeParamsGateway,
    private val memesGateway: MemesGateway
) {

    fun execute(): Single<GeneratedMeme> {
        return memeParamsGateway.getMemeParams()
            .firstOrError()
            .flatMap { memeParams ->
                memesGateway.captionImage(memeParams)
            }
    }
}