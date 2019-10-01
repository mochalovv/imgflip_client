package ru.mobileup.leenk.data.network.dto

import temp.data.network.dto.CaptionImage
import temp.data.network.dto.Meme
import temp.domain.meme.GeneratedMeme
import temp.domain.meme.MemeTemplate

// TODO: Temp
fun Ip.toIp(): ru.mobileup.leenk.domain.ipreverse.Ip {

    val parts = this.string
        .split(".")
        .map { it.toInt() }

    return ru.mobileup.leenk.domain.ipreverse.Ip(parts)
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