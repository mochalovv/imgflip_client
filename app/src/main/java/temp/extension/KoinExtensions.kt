package ru.mobileup.leenk.extension

import org.koin.android.ext.koin.androidApplication
import org.koin.core.bean.BeanDefinition
import org.koin.core.bean.Definition
import org.koin.dsl.context.Context
import org.koin.dsl.module.Module
import org.koin.dsl.module.applicationContext

/**
 * Extensions to make Koin usage more convenient for us.
 *
 * Some of them is to prepare for the lib's next release (single, module) and can be removed later.
 */

fun module(init: Context.() -> Unit): Module = applicationContext(init)

fun Context.scope(name: String, init: Context.() -> Unit): Context = context(name, init)

inline fun <reified T : Any> Context.single(
    name: String = "",
    noinline definition: Definition<T>
): BeanDefinition<T> {
    return bean(name, definition)
}

val Context.context get() = androidApplication()