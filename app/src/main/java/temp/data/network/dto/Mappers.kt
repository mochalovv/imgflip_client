package ru.mobileup.leenk.data.network.dto

// TODO: Temp
fun Ip.toIp(): ru.mobileup.leenk.domain.ipreverse.Ip {

    val parts = this.string
        .split(".")
        .map { it.toInt() }

    return ru.mobileup.leenk.domain.ipreverse.Ip(parts)
}
