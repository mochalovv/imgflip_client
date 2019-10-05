package ru.vmochalov.memegenerator.data.network.dto

import ru.vmochalov.memegenerator.domain.meme.GeneratedMeme
import ru.vmochalov.memegenerator.domain.meme.MemeTemplate

// TODO: Temp
fun Ip.toIp(): ru.vmochalov.memegenerator.domain.ipreverse.Ip {

    val parts = this.string
        .split(".")
        .map { it.toInt() }

    return ru.vmochalov.memegenerator.domain.ipreverse.Ip(parts)
}


fun Meme.toMemeTemplate(): MemeTemplate {
    return MemeTemplate(
        id,
        name,
        url,
        width,
        height
    )
}

fun CaptionImage.toGeneratedMeme(): GeneratedMeme {
    return GeneratedMeme(
        url,
        pageUrl
    )
}