package ru.vmochalov.memegenerator.domain.memeparams

import io.reactivex.Completable
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class SetMemeLabelsInteractor(
    private val memeParamsGateway: MemeParamsGateway
) {

    fun execute(firstLabel: String, secondLabel: String): Completable {
        return memeParamsGateway.setLabels(firstLabel, secondLabel)
    }
}