package ru.mobileup.leenk.data.network

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.mobileup.leenk.data.network.response.AnythingResponse
import temp.data.network.request.CaptionImageRequest
import temp.data.network.dto.CaptionImage
import temp.data.network.dto.Memes
import temp.data.network.response.BaseResponse

/**
 * Declares all api methods using Retrofit2's annotations
 */

interface ServerApi {

    // TODO: Temp
    @GET("ip")
    fun getAnything(): Single<AnythingResponse>

    @GET("get_memes")
    fun getMemes(): Single<BaseResponse<Memes>>

    @POST("caption_image")
    fun captionImage(@Body request: CaptionImageRequest): Single<BaseResponse<CaptionImage>>
}

