package ru.vmochalov.memegenerator.domain.memeparams

import io.reactivex.Completable
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.di.scopes.MainActivityScope
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
@MainActivityScope
class SetMemeLabelsInteractor @Inject constructor(
    private val memeParamsGateway: MemeParamsGateway
) {

    fun execute(labels: List<String>): Completable {
        return memeParamsGateway.setLabels(labels)
    }
}