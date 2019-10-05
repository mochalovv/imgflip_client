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

    val template = State<MemeTemplate>()

    val firstLabel = inputControl()

    val secondLabel = inputControl()

    val nextClicks = Action<Unit>()

    override fun onCreate() {
        super.onCreate()

        getMemeParamsInteractor.execute()
            .filter { it.template != null }
            .map { it.template!! }
            .firstOrError()
            .subscribe(template.consumer)
            .untilDestroy()

        nextClicks.observable
            .firstOrError()
            .flatMapCompletable {
                setMemeLabelsInteractor.execute(
                    firstLabel.text.value,
                    secondLabel.text.value
                )
            }
            .doOnComplete { sendNavigationMessage(OpenResultScreen()) }
            .subscribe()
            .untilDestroy()

    }
}