package temp.data.network.response

import com.squareup.moshi.Json

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class BaseResponse<T>(
    val success: Boolean,
    val data: T?,
    @Json(name = "error_message") val errorMessage: String?
)