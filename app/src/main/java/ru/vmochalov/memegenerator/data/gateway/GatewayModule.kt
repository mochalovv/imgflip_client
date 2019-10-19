package ru.vmochalov.memegenerator.data.gateway

import org.koin.dsl.module

object GatewayModule {

    fun create() = module {
        single { MemesGateway(get(), get()) }
        single { MemeParamsGateway(get()) }
    }
}