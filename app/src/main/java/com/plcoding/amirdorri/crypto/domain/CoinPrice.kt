package com.plcoding.amirdorri.crypto.domain

import java.time.ZonedDateTime

data class CoinPrice(
    val priceUsd : Double,
    val dateTime : ZonedDateTime
)
