package ru.vmochalov.memegenerator.data.network.request

import com.squareup.moshi.Json

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class CaptionImageRequest(
    @Json(name = "template_id") val templateId: String,
    val username: String,
    val password: String,
    val text0: String,
    val text1: String,
    val font: String?
)