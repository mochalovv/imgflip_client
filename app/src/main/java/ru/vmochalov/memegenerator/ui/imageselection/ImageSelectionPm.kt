package ru.vmochalov.memegenerator.ui.imageselection

import io.reactivex.rxkotlin.Observables
import me.dmdev.rxpm.bindProgress
import ru.vmochalov.memegenerator.domain.meme.LoadMemeTemplatesInteractor
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import ru.vmochalov.memegenerator.domain.memeparams.ClearMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SelectMemeTemplateInteractor
import ru.vmochalov.memegenerator.ui.OpenLabelsScreen
import ru.vmochalov.memegenerator.ui.common.ScreenPm
import timber.log.Timber

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class ImageSelectionPm(
    private val loadMemeTemplatesInteractor: LoadMemeTemplatesInteractor,
    private val selectMemeTemplateInteractor: SelectMemeTemplateInteractor,
    private val clearMemeParamsInteractor: ClearMemeParamsInteractor
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


    override fun onCreate() {
        super.onCreate()

        clearMemeParamsInteractor.execute()

        loadMemeTemplatesInteractor.execute()
            .bindProgress(progressVisible.consumer)
            .doOnSuccess {
                if (it.isNotEmpty()) {
                    templates.consumer.accept(it)
                    selectedTemplate.consumer.accept(it.first())
                }
            }
            .subscribe(
                { Timber.d("Meme templates are loaded") },
                { Timber.e("Error while loading memes: ${it.message}") }
            )
            .untilDestroy()

        templateSelectedClicks.observable
            .map { it.template }
            .subscribe(selectedTemplate.consumer)
            .untilDestroy()

        nextClicks.observable
            .firstOrError()
            .flatMapCompletable { selectMemeTemplateInteractor.execute(selectedTemplate.value) }
            .doOnComplete {
                sendNavigationMessage(OpenLabelsScreen())
            }
            .subscribe()
            .untilDestroy()

    }

}