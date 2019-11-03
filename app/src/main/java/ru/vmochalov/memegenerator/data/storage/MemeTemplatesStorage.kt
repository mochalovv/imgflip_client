package ru.vmochalov.memegenerator.data.storage

import ru.vmochalov.memegenerator.data.storage.common.InMemoryStorage
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
@Singleton
class MemeTemplatesStorage @Inject constructor() : InMemoryStorage<List<MemeTemplate>>()