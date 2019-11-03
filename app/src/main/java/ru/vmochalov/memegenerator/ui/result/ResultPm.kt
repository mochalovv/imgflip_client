package ru.vmochalov.memegenerator.ui.result

import me.dmdev.rxpm.action
import me.dmdev.rxpm.bindProgress
import me.dmdev.rxpm.state
import me.dmdev.rxpm.widget.dialogControl
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.data.system.ClipboardHelper
import ru.vmochalov.memegenerator.data.system.ResourceHelper
import ru.vmochalov.memegenerator.domain.SaveMemeToGalleryInteractor
import ru.vmochalov.memegenerator.domain.meme.GenerateMemeInteractor
import ru.vmochalov.memegenerator.domain.meme.GeneratedMeme
import ru.vmochalov.memegenerator.ui.OpenTemplateSelectionScreen
import ru.vmochalov.memegenerator.ui.OpenUrl
import ru.vmochalov.memegenerator.ui.common.ScreenPm
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class ResultPm @Inject constructor(
    private val generateMemeInteractor: GenerateMemeInteractor,
    private val clipboardHelper: ClipboardHelper,
    private val resourceHelper: ResourceHelper,
    private val saveMemeToGalleryInteractor: SaveMemeToGalleryInteractor
) : ScreenPm() {

    val meme = state<GeneratedMeme>()
    val progressVisible = state(false)

    val retryClicks = action<Unit>()
    val urlClicks = action<Unit>()
    val copyUrlClicks = action<Unit>()
    val saveToGalleryClicks = action<Unit>()
    val newMemeClicks = action<Unit>()

    val loadingErrorDialog = dialogControl<String, Unit>()
    val galleryErrorDialog = dialogControl<String, Unit>()

    override fun onCreate() {
        super.onCreate()

        retryClicks.observable
            .flatMapSingle {
                generateMemeInteractor.execute()
                    .bindProgress(progressVisible.consumer)
                    .doOnError {
                        loadingErrorDialog.show(resourceHelper.getString(R.string.error_dialog_message))
                    }
                    .doOnSuccess(meme.consumer)
            }
            .retry()
            .subscribe()
            .untilDestroy()

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
            .flatMapCompletable {
                saveMemeToGalleryInteractor.execute(meme.value.url)
            }
            .doOnError {
                galleryErrorDialog.show(
                    it.message ?: resourceHelper.getString(R.string.result_gallery_error)
                )
            }
            .retry()
            .subscribe()
            .untilDestroy()

        newMemeClicks.observable
            .doOnNext {
                sendNavigationMessage(OpenTemplateSelectionScreen())
            }
            .subscribe()
            .untilDestroy()

        generateMeme()
    }

    private fun generateMeme() {
        retryClicks.consumer.accept(Unit)
    }

}