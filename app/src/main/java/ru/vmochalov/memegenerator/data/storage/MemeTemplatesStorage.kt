package ru.vmochalov.memegenerator.data.storage

import ru.vmochalov.memegenerator.data.storage.common.InMemoryStorage
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
class MemeTemplatesStorage : InMemoryStorage<List<MemeTemplate>>()