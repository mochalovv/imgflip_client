package temp.data.storage.common

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Observable

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
open class InMemoryStorage<T> : RxStorage<T> {

    private val relay = BehaviorRelay.create<T>()

    override fun get(): Observable<T> {
        return relay.hide()
    }

    override fun set(value: T) {
        relay.accept(value)
    }

    override fun getValueOrNull(): T? {
        return relay.value
    }

}