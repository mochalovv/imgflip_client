package ru.vmochalov.memegenerator.domain.meme

import io.reactivex.Single
import ru.vmochalov.memegenerator.data.gateway.MemesGateway

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class GenerateMemeInteractor(
    private val memesGateway: MemesGateway
) {

    fun execute(memeParams: MemeParams): Single<GeneratedMeme> {
        return memesGateway.captionImage("username", "password", memeParams)
    }
}