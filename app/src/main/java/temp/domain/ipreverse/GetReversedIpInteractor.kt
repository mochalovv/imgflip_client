package ru.mobileup.leenk.domain.ipreverse

import io.reactivex.Single
import ru.mobileup.leenk.data.gateway.MemesGateway

// TODO: Temp
class GetReversedIpInteractor(private val memesGateway: MemesGateway) {

    fun execute(): Single<Ip> {
        return memesGateway
            .getAnythingIp()
            .map { ip ->
                ReverseIpEntity(ip).reverseIp()
            }
    }
}