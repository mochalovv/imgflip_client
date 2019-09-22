package ru.mobileup.leenk.data.gateway

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.mobileup.leenk.data.network.ServerApi
import ru.mobileup.leenk.data.network.dto.Ip
import ru.mobileup.leenk.data.network.dto.toIp


class AnythingGateway(private val api: ServerApi) { // TODO: Temp

    fun getAnythingIp(): Single<ru.mobileup.leenk.domain.ipreverse.Ip> =
        api.getAnything()
            .map { response ->
                val serverIp = response.ip.substring(0, response.ip.indexOf(","))
                Ip(serverIp).toIp()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}