package com.plcoding.amirdorri.crypto.presentation.coin_list

import com.plcoding.amirdorri.core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error (val message : NetworkError) : CoinListEvent
}