package ru.vmochalov.memegenerator.domain.meme

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class MemeParams(
    val template: MemeTemplate?,
    val labels: List<String>
) {
    companion object {
        val EMPTY_MEME_PARAMS = MemeParams(null, emptyList())
    }
}