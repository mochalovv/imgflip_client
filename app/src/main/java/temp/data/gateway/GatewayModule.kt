package ru.mobileup.leenk.data.gateway

import ru.mobileup.leenk.extension.module
import ru.mobileup.leenk.extension.single

object GatewayModule {

    fun create() = module {
        single { MemesGateway(get(), get()) }
    }
}