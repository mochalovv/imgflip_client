package ru.vmochalov.memegenerator.domain.memeparams

import io.reactivex.Observable
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.domain.meme.MemeParams

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class GetMemeParamsInteractor(
    private val memeParamsGateway: MemeParamsGateway
) {

    fun execute(): Observable<MemeParams> {
        return memeParamsGateway.getMemeParams()
    }
}