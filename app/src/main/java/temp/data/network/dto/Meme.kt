package temp.data.network.dto

import com.squareup.moshi.Json

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class Meme(
    val id: String,
    val name: String,
    val url: String,
    val width: Int,
    val height: Int,
    @Json(name = "box_count") val boxCount: Int
)