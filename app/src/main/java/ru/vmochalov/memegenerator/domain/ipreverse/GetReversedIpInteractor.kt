package ru.vmochalov.memegenerator.domain.ipreverse

import io.reactivex.Single
import ru.vmochalov.memegenerator.data.gateway.MemesGateway

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