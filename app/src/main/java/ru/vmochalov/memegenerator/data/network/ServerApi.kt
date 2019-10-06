package ru.vmochalov.memegenerator.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.vmochalov.memegenerator.data.network.dto.CaptionImage
import ru.vmochalov.memegenerator.data.network.dto.Memes
import ru.vmochalov.memegenerator.data.network.response.AnythingResponse
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

    @GET("caption_image")
    fun captionImage(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("template_id") templateId: String,
        @Query("text0") firstLabel: String,
        @Query("text1") secondLabel: String
    ): Single<BaseResponse<CaptionImage>>

}

