package ru.mobileup.leenk.ui.anything

import ru.mobileup.leenk.data.system.ResourceHelper
import ru.mobileup.leenk.domain.ipreverse.GetReversedIpInteractor
import ru.mobileup.leenk.ui.OpenAnythingScreen
import ru.mobileup.leenk.ui.common.ScreenPm

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
            .subscribe { sendNavigationMessage(OpenAnythingScreen(numberParam + 1)) }
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