package com.plcoding.amirdorri.crypto.data.networking.dto

import kotlinx.serialization.Serializable

@Serializable
data class CoinsResponseDto(
    val data : List <CoinDto>
)
