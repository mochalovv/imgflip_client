package ru.mobileup.leenk.domain.ipreverse

import io.reactivex.Single
import ru.mobileup.leenk.data.gateway.AnythingGateway

// TODO: Temp
class GetReversedIpInteractor(private val anythingGateway: AnythingGateway) {

    fun execute(): Single<Ip> {
        return anythingGateway
            .getAnythingIp()
            .map { ip ->
                ReverseIpEntity(ip).reverseIp()
            }
    }
}