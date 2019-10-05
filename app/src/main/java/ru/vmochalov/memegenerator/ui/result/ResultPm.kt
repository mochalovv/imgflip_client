package ru.vmochalov.memegenerator.ui.result

import me.dmdev.rxpm.bindProgress
import ru.vmochalov.memegenerator.domain.meme.GenerateMemeInteractor
import ru.vmochalov.memegenerator.domain.meme.GeneratedMeme
import ru.vmochalov.memegenerator.ui.OpenTemplateSelectionScreen
import ru.vmochalov.memegenerator.ui.common.ScreenPm
import timber.log.Timber

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class ResultPm(
    private val generateMemeInteractor: GenerateMemeInteractor
) : ScreenPm() {

    val meme = State<GeneratedMeme>()

    val progressVisible = State(false)
    val retryButtonVisible = State(false)

    val retryClicks = Action<Unit>()
    val copyClicks = Action<Unit>()
    val saveToGalleryClicks = Action<Unit>()
    val newMemeClicks = Action<Unit>()

    override fun onCreate() {
        super.onCreate()

        retryClicks.observable
            .flatMapSingle {
                generateMemeInteractor.execute()
                    .bindProgress(progressVisible.consumer)
                    .doOnSubscribe {
                        retryButtonVisible.consumer.accept(false)
                    }
                    .doOnError {
                        retryButtonVisible.consumer.accept(true)
                    }
                    .doOnSuccess {
                        meme.consumer.accept(it)
                    }
            }
            .retry()
            .subscribe()

        triggerMemeGeneration()

        copyClicks.observable
            .doOnNext { Timber.d("!! copy clicked") }
            .subscribe()
            .untilDestroy()

        saveToGalleryClicks.observable
            .doOnNext { Timber.d("!! save clicked") }
            .subscribe()
            .untilDestroy()

        newMemeClicks.observable
            .doOnNext {
                sendNavigationMessage(OpenTemplateSelectionScreen())
            }
            .subscribe()
            .untilDestroy()

    }

    private fun triggerMemeGeneration() {
        retryClicks.consumer.accept(Unit)
    }

}