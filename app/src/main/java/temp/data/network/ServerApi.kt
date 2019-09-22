package ru.mobileup.leenk.data.network

import io.reactivex.Single
import retrofit2.http.GET
import ru.mobileup.leenk.data.network.response.AnythingResponse

/**
 * Declares all api methods using Retrofit2's annotations
 */
interface ServerApi {

    // TODO: Temp
    @GET("ip")
    fun getAnything(): Single<AnythingResponse>
}

