package ru.vmochalov.memegenerator.ui.labels

import io.reactivex.rxkotlin.combineLatest
import me.dmdev.rxpm.action
import me.dmdev.rxpm.state
import me.dmdev.rxpm.widget.inputControl
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import ru.vmochalov.memegenerator.domain.memeparams.GetMemeParamsInteractor
import ru.vmochalov.memegenerator.domain.memeparams.SetMemeLabelsInteractor
import ru.vmochalov.memegenerator.ui.OpenResultScreen
import ru.vmochalov.memegenerator.ui.common.ScreenPm
import javax.inject.Inject

/**
 * Created by Vladimir Mochalov on 05.10.2019.
 */
class LabelsPm @Inject constructor(
    private val getMemeParamsInteractor: GetMemeParamsInteractor,
    private val setMemeLabelsInteractor: SetMemeLabelsInteractor
) : ScreenPm() {

    companion object {
        private const val LABELS_LIMIT = 5
    }

    val template = state<MemeTemplate>()

    val lastVisibleLabelIndex = state<Int>()

    val labels = (0 until LABELS_LIMIT).map { inputControl() }

    val labelsVisibilities = (0 until LABELS_LIMIT).map { state(false) }

    val nextButtonAvailability = state<Boolean>()

    val nextClicks = action<Unit>()

    override fun onCreate() {
        super.onCreate()

        template.observable
            .map { it.boxCount - 1 }
            .subscribe(lastVisibleLabelIndex.consumer)
            .untilDestroy()

        labels.map { it.text.observable }
            .combineLatest { isNextButtonAvailable(it) }
            .subscribe(nextButtonAvailability.consumer)
            .untilDestroy()

        nextButtonAvailability

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
            .map {
                labels.map { it.text.value }
                    .take(template.value.boxCount)
            }
            .flatMapCompletable { visibleLabels ->
                setMemeLabelsInteractor
                    .execute(visibleLabels)
                    .doOnComplete { sendNavigationMessage(OpenResultScreen()) }
            }
            .subscribe()
            .untilDestroy()

    }

    private fun isNextButtonAvailable(labels: List<String>): Boolean {
        var available = false

        for (label in labels) {
            if (label.isNotBlank()) {
                available = true
                break
            }
        }

        return available
    }
}