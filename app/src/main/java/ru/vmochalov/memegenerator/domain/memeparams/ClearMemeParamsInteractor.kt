package ru.vmochalov.memegenerator.domain.memeparams

import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
@MainActivityScope
class ClearMemeParamsInteractor @Inject constructor(
    private val memeParamsGateway: MemeParamsGateway
) {
    fun execute() {
        memeParamsGateway.clearMemeParamsGateway()
    }
}