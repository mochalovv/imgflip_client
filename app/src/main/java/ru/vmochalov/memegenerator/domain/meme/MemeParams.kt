package ru.vmochalov.memegenerator.domain.meme

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class MemeParams(
    val template: MemeTemplate?,
    val text0: String,
    val text1: String,
    val font: String?
) {
    companion object {
        val EMPTY_MEME_PARAMS = MemeParams(null, "", "", null)
    }
}