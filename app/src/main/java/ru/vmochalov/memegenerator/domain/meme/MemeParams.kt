package ru.vmochalov.memegenerator.domain.meme

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class MemeParams(
    val templateId: String,
    val text0: String,
    val text1: String,
    val font: String
)