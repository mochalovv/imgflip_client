package ru.mobileup.leenk

import ru.mobileup.leenk.data.gateway.GatewayModule
import ru.mobileup.leenk.data.network.NetworkModule
import ru.mobileup.leenk.data.storage.StorageModule
import ru.mobileup.leenk.data.system.SystemModule
import ru.mobileup.leenk.domain.InteractorModule
import ru.mobileup.leenk.ui.PmModule

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