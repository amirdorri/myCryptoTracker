package com.plcoding.amirdorri.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinPriceDto(
    val priceUsd : Double,
    val time : Long
)
