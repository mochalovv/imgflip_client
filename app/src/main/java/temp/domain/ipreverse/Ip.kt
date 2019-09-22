package ru.mobileup.leenk.domain.ipreverse

// TODO: Temp
data class Ip(val parts: List<Int>) {

    override fun toString(): String {
        return parts.joinToString("-", "ip:")
    }
}