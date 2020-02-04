package ru.vmochalov.memegenerator.data.network.dto

import com.squareup.moshi.Json

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class CaptionImage(
    val url: String,
    @Json(name = "page_url") val pageUrl: String
)