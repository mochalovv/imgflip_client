package ru.vmochalov.memegenerator.ui.anything

import ru.vmochalov.memegenerator.data.system.ResourceHelper
import ru.vmochalov.memegenerator.domain.ipreverse.GetReversedIpInteractor
import ru.vmochalov.memegenerator.ui.OpenAnythingScreen
import ru.vmochalov.memegenerator.ui.common.ScreenPm

// TODO: Temp
class AnythingPm(
    private val numberParam: Int,
    private val resourceHelper: ResourceHelper,
    private val getReversedIp: GetReversedIpInteractor
) : ScreenPm() {


    val number = State<String>(numberParam.toString())
    val ip = State<String>("Загрузка...")

    val numberClicks = Action<Unit>()

    override fun onCreate() {
        super.onCreate()

        numberClicks.observable
            .subscribe { sendNavigationMessage(
                OpenAnythingScreen(
                    numberParam + 1
                )
            ) }
            .untilDestroy()

        getReversedIp.execute()
            .subscribe(
                {
                    ip.consumer.accept(it.toString())
                },
                {
                    ip.consumer.accept("Ошибка загрузки!")
                }
            )
            .untilDestroy()
    }
}