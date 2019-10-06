package ru.vmochalov.memegenerator.ui.result

import me.dmdev.rxpm.bindProgress
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.data.system.ClipboardHelper
import ru.vmochalov.memegenerator.data.system.ResourceHelper
import ru.vmochalov.memegenerator.domain.meme.GenerateMemeInteractor
import ru.vmochalov.memegenerator.domain.meme.GeneratedMeme
import ru.vmochalov.memegenerator.ui.OpenTemplateSelectionScreen
import ru.vmochalov.memegenerator.ui.OpenUrl
import ru.vmochalov.memegenerator.ui.common.ScreenPm
import timber.log.Timber

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class ResultPm(
    private val generateMemeInteractor: GenerateMemeInteractor,
    private val clipboardHelper: ClipboardHelper,
    private val resourceHelper: ResourceHelper
) : ScreenPm() {

    val meme = State<GeneratedMeme>()

    val progressVisible = State(false)
    val retryButtonVisible = State(false)

    val retryClicks = Action<Unit>()
    val urlClicks = Action<Unit>()
    val copyUrlClicks = Action<Unit>()
    val saveToGalleryClicks = Action<Unit>()
    val newMemeClicks = Action<Unit>()

    //    todo: make buttons work; add more edittexts for labels; add proper scrolling
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

        urlClicks.observable
            .doOnNext {
                sendNavigationMessage(OpenUrl(meme.value.url))
            }
            .subscribe()
            .untilDestroy()

        copyUrlClicks.observable
            .doOnNext {
                clipboardHelper.copyToClipboard(
                    resourceHelper.getString(R.string.result_clipboard_label),
                    meme.value.url
                )
            }
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