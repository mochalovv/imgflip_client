package ru.mobileup.leenk.data.network

import io.reactivex.Single
import retrofit2.http.GET
import ru.mobileup.leenk.data.network.response.AnythingResponse

/**
 * Declares all api methods using Retrofit2's annotations
 */

//todo: https://api.imgflip.com/
interface ServerApi {

    // TODO: Temp
    @GET("ip")
    fun getAnything(): Single<AnythingResponse>
}

