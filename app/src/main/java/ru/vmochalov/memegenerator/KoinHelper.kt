package ru.vmochalov.memegenerator

import org.koin.KoinContext
import org.koin.standalone.StandAloneContext

/**
 * Helps to use **Koin** in more convenient way.
 *
 * Use instance of this class if you need test open/close scope and mock dependencies.
 */
class KoinHelper {

    companion object {

        private var scopeToPropertyNames = mutableMapOf<String, Set<String>>()

        val koinContext = StandAloneContext.koinContext as KoinContext

        inline fun <reified T> get(name: String = ""): T = koinContext.get(name)

        inline fun <reified T> getWithProperties(
            vararg properties: Pair<String, Any>,
            name: String = ""
        ): T {
            properties.forEach { (propertyName, property) ->
                koinContext.setProperty(propertyName, property)
            }
            val result = koinContext.get<T>(name)
            koinContext.releaseProperties(*properties.toMap().keys.toTypedArray())
            return result
        }
    }

    fun openScope(name: String, vararg properties: Pair<String, Any>) {
        koinContext.releaseContext(name)
        properties.forEach { (propertyName, property) ->
            koinContext.setProperty(propertyName, property)
        }
        scopeToPropertyNames[name] = properties.toMap().keys
    }

    fun closeScope(name: String = "") {
        koinContext.releaseContext(name)
        scopeToPropertyNames[name]?.let {
            koinContext.releaseProperties(*it.toTypedArray())
        }
    }
}