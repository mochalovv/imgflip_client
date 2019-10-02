package ru.vmochalov.memegenerator.domain.meme

import io.reactivex.Completable

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class SelectMemeTemplateInteractor {
    fun execute(): Completable {
        return Completable.complete()
    }
}