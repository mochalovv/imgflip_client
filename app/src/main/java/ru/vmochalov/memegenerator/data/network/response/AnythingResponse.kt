package ru.vmochalov.memegenerator.data.network.response

import com.squareup.moshi.Json

// TODO: Temp
data class AnythingResponse(
    @Json(name = "origin") val ip: String
)