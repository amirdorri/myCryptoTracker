package com.plcoding.amirdorri.crypto.presentation.coin_list

import com.plcoding.amirdorri.crypto.presentation.models.CoinUi

sealed interface CoinListAction {

    data class OnCoinClick( val coinUi: CoinUi ) : CoinListAction
    data object OnRefresh : CoinListAction


}