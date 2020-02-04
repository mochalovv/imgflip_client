package ru.vmochalov.memegenerator.data.network.dto

import ru.vmochalov.memegenerator.domain.meme.GeneratedMeme
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate

fun Meme.toMemeTemplate(): MemeTemplate {
    return MemeTemplate(
        id,
        name,
        url,
        width,
        height,
        boxCount
    )
}

fun CaptionImage.toGeneratedMeme(): GeneratedMeme {
    return GeneratedMeme(
        url,
        pageUrl
    )
}