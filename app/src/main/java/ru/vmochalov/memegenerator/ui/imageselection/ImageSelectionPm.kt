package ru.vmochalov.memegenerator.ui.imageselection

import io.reactivex.rxkotlin.Observables
import me.dmdev.rxpm.bindProgress
import me.dmdev.rxpm.widget.dialogControl
import ru.vmochalov.memegenerator.R
import ru.vmochalov.memegenerator.data.system.ResourceHelper
import ru.vmochalov.memegenerator.domain.meme.LoadMemeTemplatesInteractor
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import ru.vmochalov.memegenerator.domain.memeparams.ClearMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SelectMemeTemplateInteractor
import ru.vmochalov.memegenerator.ui.OpenLabelsScreen
import ru.vmochalov.memegenerator.ui.common.ScreenPm

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class ImageSelectionPm(
    private val loadMemeTemplatesInteractor: LoadMemeTemplatesInteractor,
    private val selectMemeTemplateInteractor: SelectMemeTemplateInteractor,
    private val clearMemeParamsInteractor: ClearMemeParamsInteractor,
    private val resourceHelper: ResourceHelper
) : ScreenPm() {

    val progressVisible = State<Boolean>()
    val selectedTemplate = State<MemeTemplate>()
    private val templates = State<List<MemeTemplate>>()

    val templateItems = Observables.combineLatest(
        templates.observable,
        selectedTemplate.observable
    ) { templates, selectedTemplate ->
        templates.map { TemplateItem(it, it.id == selectedTemplate.id) }
    }

    val templateSelectedClicks = Action<TemplateItem>()
    val nextClicks = Action<Unit>()

    val retryClicks = Action<Unit>()

    val errorDialog = dialogControl<String, Unit>()

    override fun onCreate() {
        super.onCreate()

        retryClicks.observable
            .flatMapCompletable {
                loadMemeTemplatesInteractor.execute()
                    .bindProgress(progressVisible.consumer)
                    .doOnSuccess {
                        if (it.isNotEmpty()) {
                            templates.consumer.accept(it)
                            selectedTemplate.consumer.accept(it.first())
                        }
                    }
                    .doOnError {
                        errorDialog.show(resourceHelper.getString(R.string.error_dialog_message))
                    }
                    .ignoreElement()
            }
            .retry()
            .subscribe()
            .untilDestroy()

        templateSelectedClicks.observable
            .map { it.template }
            .subscribe(selectedTemplate.consumer)
            .untilDestroy()

        nextClicks.observable
            .flatMapCompletable {
                selectMemeTemplateInteractor.execute(selectedTemplate.value)
                    .doOnComplete {
                        sendNavigationMessage(OpenLabelsScreen())
                    }
            }
            .subscribe()
            .untilDestroy()

        loadTemplatesInitially()
    }

    private fun loadTemplatesInitially() {
        retryClicks.consumer.accept(Unit)
    }

    override fun onBind() {
        super.onBind()

        clearMemeParamsInteractor.execute()
    }

}