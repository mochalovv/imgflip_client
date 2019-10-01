package temp.ui.imageselection

import io.reactivex.rxkotlin.Observables
import me.dmdev.rxpm.bindProgress
import ru.mobileup.leenk.ui.common.ScreenPm
import temp.domain.meme.LoadMemeTemplatesInteractor
import temp.domain.meme.MemeTemplate
import temp.domain.meme.SelectMemeTemplateInteractor
import timber.log.Timber

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class ImageSelectionPm(
    private val loadMemeTemplatesInteractor: LoadMemeTemplatesInteractor,
    private val selectMemeTemplateInteractor: SelectMemeTemplateInteractor
) : ScreenPm() {


    val progressVisible = State<Boolean>()

//    val selectedTemplateUrl = State<String>()

    val selectedTemplate = State<MemeTemplate>()
    private val templates = State<List<MemeTemplate>>()

    val templateItems = Observables.combineLatest(
        templates.observable,
        selectedTemplate.observable
    ) { templates, selectedTemplate ->
        templates.map { toTemplateItem(it, it.id == selectedTemplate.id) }
    }

    val templateSelectedClicks = Action<TemplateItem>()
    val nextClicks = Action<Unit>()


    override fun onCreate() {
        super.onCreate()

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
            .doOnNext {
                Timber.d("Next clicked")
            }
            .subscribe()
            .untilDestroy()

    }

    private fun toTemplateItem(template: MemeTemplate, selected: Boolean): TemplateItem {
        return TemplateItem(
            template,
            selected
        )
    }
}