package ru.vmochalov.memegenerator

import ru.vmochalov.memegenerator.data.gateway.GatewayModule
import ru.vmochalov.memegenerator.data.network.NetworkModule
import ru.vmochalov.memegenerator.data.storage.StorageModule
import ru.vmochalov.memegenerator.data.system.SystemModule
import ru.vmochalov.memegenerator.domain.InteractorModule
import ru.vmochalov.memegenerator.ui.PmModule

fun allModules() = listOf(
    AppModule.create(),
    GatewayModule.create(),
    NetworkModule.create(),
    StorageModule.create(),
    SystemModule.create(),
    InteractorModule.create(),
    PmModule.create()
)

/**
 * DI scopes names.
 */
object Scopes {
    const val USER = "user_scope"
}