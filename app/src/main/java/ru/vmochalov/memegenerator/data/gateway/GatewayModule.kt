package ru.vmochalov.memegenerator.data.gateway

import ru.vmochalov.memegenerator.extension.module
import ru.vmochalov.memegenerator.extension.single

object GatewayModule {

    fun create() = module {
        single { MemesGateway(get(), get()) }
        single { MemeParamsGateway(get()) }
    }
}