package ru.vmochalov.memegenerator.domain.memeparams

import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class ClearMemeParamsInteractor(
    private val memeParamsGateway: MemeParamsGateway
) {
    fun execute() {
        memeParamsGateway.clearMemeParamsGateway()
    }
}