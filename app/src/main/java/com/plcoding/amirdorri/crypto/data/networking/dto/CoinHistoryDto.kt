package com.plcoding.amirdorri.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinHistoryDto(
    val data : List <CoinPriceDto>
)
