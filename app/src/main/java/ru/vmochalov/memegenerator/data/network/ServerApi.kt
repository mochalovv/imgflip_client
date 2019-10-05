package ru.vmochalov.memegenerator.data.network

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import ru.vmochalov.memegenerator.data.network.response.AnythingResponse
import ru.vmochalov.memegenerator.data.network.request.CaptionImageRequest
import ru.vmochalov.memegenerator.data.network.dto.CaptionImage
import ru.vmochalov.memegenerator.data.network.dto.Memes
import ru.vmochalov.memegenerator.data.network.response.BaseResponse

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
