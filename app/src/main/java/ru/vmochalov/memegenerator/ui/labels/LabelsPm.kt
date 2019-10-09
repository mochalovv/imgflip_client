package ru.vmochalov.memegenerator.ui.labels

import me.dmdev.rxpm.widget.inputControl
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import ru.vmochalov.memegenerator.domain.memeparams.GetMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SetMemeLabelsInteractor
import ru.vmochalov.memegenerator.ui.OpenResultScreen
import ru.vmochalov.memegenerator.ui.common.ScreenPm

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class LabelsPm(
    private val getMemeParamsInteractor: GetMemeParamsInteractor,
    private val setMemeLabelsInteractor: SetMemeLabelsInteractor
) : ScreenPm() {

    companion object {
        private const val LABELS_LIMIT = 5
    }

    val template = State<MemeTemplate>()
    val lastVisibleLabelIndex = template.observable.map { it.boxCount - 1 }

    val labels = (0 until LABELS_LIMIT).map { inputControl() }
    val labelsVisibilities = (0 until LABELS_LIMIT).map { State(false) }

    val nextClicks = Action<Unit>()

    override fun onCreate() {
        super.onCreate()

        getMemeParamsInteractor.execute()
            .filter { it.template != null }
            .map { it.template!! }
            .subscribe(template.consumer)
            .untilDestroy()

        template.observable
            .map { it.boxCount }
            .doOnNext { boxCount ->
                labelsVisibilities.forEachIndexed { index, state ->
                    state.consumer.accept(index < boxCount)
                }
            }
            .subscribe()
            .untilDestroy()

        nextClicks.observable
            .flatMapCompletable {
                setMemeLabelsInteractor
                    .execute(
                        labels.map { it.text.value }
                            .take(template.value.boxCount)
                    )
                    .doOnComplete { sendNavigationMessage(OpenResultScreen()) }
            }
            .subscribe()
            .untilDestroy()

    }
}