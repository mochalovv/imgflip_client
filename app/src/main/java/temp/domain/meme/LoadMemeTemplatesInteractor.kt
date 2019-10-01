package temp.domain.meme

import io.reactivex.Single
import ru.mobileup.leenk.data.gateway.MemesGateway

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class LoadMemeTemplatesInteractor(
    private val memesGateway: MemesGateway
) {

    fun execute(): Single<List<MemeTemplate>> {
        return memesGateway.getMemeTemplates()
    }
}