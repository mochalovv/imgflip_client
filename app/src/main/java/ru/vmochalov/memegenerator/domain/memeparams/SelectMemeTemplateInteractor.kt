package ru.vmochalov.memegenerator.domain.memeparams

import io.reactivex.Completable
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
@MainActivityScope
class SelectMemeTemplateInteractor @Inject constructor(
    private val memeParamsGateway: MemeParamsGateway
) {
    fun execute(template: MemeTemplate): Completable {
        return memeParamsGateway.setTemplate(template)
    }
}