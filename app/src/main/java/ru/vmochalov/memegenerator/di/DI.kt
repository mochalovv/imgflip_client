package ru.vmochalov.memegenerator.di

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