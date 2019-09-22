package ru.mobileup.leenk.extension

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addTo(compositeDisposable: CompositeDisposable) {
    compositeDisposable.add(this)
}

fun <T> Observable<T>.filterFrequentItems(): Observable<T> {

    val minItemsGapLimitMillis = 500

    return this
        .timestamp()
        .distinctUntilChanged { first, second ->
            second.time() - first.time() < minItemsGapLimitMillis
        }
        .map { it.value() }
}
