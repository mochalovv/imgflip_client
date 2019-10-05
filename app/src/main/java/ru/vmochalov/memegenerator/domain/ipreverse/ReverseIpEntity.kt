package ru.vmochalov.memegenerator.domain.ipreverse

// TODO: Temp
class ReverseIpEntity(private val ip: Ip) {

    // Imagine this is some really special domain or higher-level logic
    fun reverseIp() = Ip(ip.parts.reversed())
}