package ru.vmochalov.memegenerator.data.network.dto

import com.squareup.moshi.Json

/**
 * Created by Vladimir Mochalov on 22.09.2019.
 */
data class MemeImage(
    val id: String,
    val name: String,
    val url: String,
    val width: Int,
    val height: Int,
    @Json(name = "box_count") val boxCount: Int
)
//{"id":"112126428","name":"Distracted Boyfriend","url":"https:\/\/i.imgflip.com\/1ur9b0.jpg","width":1200,"height":800,"box_count":3}