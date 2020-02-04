package ru.vmochalov.memegenerator.data.storage.common

import io.reactivex.Observable

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
interface RxStorage<T> {

    fun set(value: T)

    fun get(): Observable<T>

    fun getValueOrNull(): T?
}