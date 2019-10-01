package temp.domain.meme

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class MemeTemplate(
    val id: String,
    val name: String,
    val url: String,
    val width: Int,
    val height: Int
)