package ru.vmochalov.memegenerator.di

import org.koin.dsl.module
import ru.vmochalov.memegenerator.data.gateway.MemeParamsGateway
import ru.vmochalov.memegenerator.data.gateway.MemesGateway

object GatewayModule {

    fun create() = module {
        single { MemesGateway(get(), get()) }
        single { MemeParamsGateway(get()) }
    }
}