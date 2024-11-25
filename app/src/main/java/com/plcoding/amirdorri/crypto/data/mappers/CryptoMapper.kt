package com.plcoding.amirdorri.crypto.data.mappers

import com.plcoding.amirdorri.crypto.data.networking.dto.CoinDto
import com.plcoding.amirdorri.crypto.data.networking.dto.CoinPriceDto
import com.plcoding.amirdorri.crypto.domain.Coin
import com.plcoding.amirdorri.crypto.domain.CoinPrice
import java.time.Instant
import java.time.ZoneId

fun CoinDto.toCoin () : Coin{

    return Coin(
        id, rank, name, symbol, marketCapUsd, priceUsd, changePercent24Hr
    )
}

fun CoinPriceDto.toCoinPrice() : CoinPrice {
    return CoinPrice(
        priceUsd = priceUsd,
        dateTime = Instant.ofEpochMilli(time)
            .atZone(ZoneId.systemDefault())
    )
}