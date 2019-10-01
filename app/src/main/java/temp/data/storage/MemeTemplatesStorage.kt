package temp.data.storage

import temp.data.storage.common.InMemoryStorage
import temp.domain.meme.MemeTemplate

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class MemeTemplatesStorage : InMemoryStorage<List<MemeTemplate>>()