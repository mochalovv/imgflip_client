package ru.vmochalov.memegenerator.ui.imageselection

import ru.vmochalov.memegenerator.domain.meme.MemeTemplate

/**
 * Created by Vladimir Mochalov on 28.09.2019.
 */
data class TemplateItem(
    val template: MemeTemplate,
    val selected: Boolean
)


