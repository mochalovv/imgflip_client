package ru.vmochalov.memegenerator.domain.memeparams

import io.reactivex.Observable
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import ru.vmochalov.memegenerator.domain.meme.MemeParams
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
@MainActivityScope
class GetMemeParamsInteractor @Inject constructor(
    private val memeParamsGateway: MemeParamsGateway
) {

    fun execute(): Observable<MemeParams> {
        return memeParamsGateway.getMemeParams()
    }
}