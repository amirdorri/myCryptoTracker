package com.plcoding.amirdorri.di

import com.plcoding.amirdorri.core.data.networking.HttpClientFactory
import com.plcoding.amirdorri.crypto.data.networking.RemoteCoinDataSource
import com.plcoding.amirdorri.crypto.domain.CoinDataSource
import com.plcoding.amirdorri.crypto.presentation.coin_list.CoinListViewModel
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {

    single { HttpClientFactory.create(CIO.create()) }
    //single { RemoteCoinDataSource(get()) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()

    viewModelOf(::CoinListViewModel)

}