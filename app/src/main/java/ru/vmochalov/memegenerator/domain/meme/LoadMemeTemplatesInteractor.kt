package ru.vmochalov.memegenerator.domain.meme

import io.reactivex.Single
import ru.vmochalov.memegenerator.data.gateway.MemesGateway
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
@MainActivityScope
class LoadMemeTemplatesInteractor @Inject constructor(
    private val memesGateway: MemesGateway
) {

    fun execute(): Single<List<MemeTemplate>> {
        return memesGateway.getMemeTemplates()
    }
}