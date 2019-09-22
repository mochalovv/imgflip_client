package ru.vmochalov.memegenerator.data.network.dto

/**
 * Created by Vladimir Mochalov on 22.09.2019.
 */
data class Response<T>(
    val success: Boolean,
    val data: T?,
    val errorMessage: String?
)