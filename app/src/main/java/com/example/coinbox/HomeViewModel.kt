package com.example.coinbox

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.Coins
import com.example.data.NetworkHelper
import com.example.domain.CoinRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var coinRepository : CoinRepository): ViewModel() {

    var baseClient = BaseClient()

    private var _liveCoins : MutableLiveData<NetworkHelper<Coins>> = MutableLiveData()
    var liveCoins : LiveData<NetworkHelper<Coins>> =  _liveCoins

    fun getAllCoins(){
        viewModelScope.launch {
                var result = coinRepository.getCoins()
               _liveCoins.value =  baseClient.handleGamesResponse(result)
            }
    }
}



class  BaseClient{
    fun <T> handleGamesResponse(response: Response<T>): NetworkHelper<T> {
        println("HELLOTRIGGERED")
        println("HELLOTRIGGEREDBOB ${response.code()}")
        println("HELLOTRIGGEREDBOB ${response.body()}")
        when {
            response.isSuccessful -> {
                val result = response.body()
                return NetworkHelper.Success(result!!)
            }

            response.code() == 404  || response.code() == 400  || response.code() == 401  || response.code() == 403  || response.code() == 500  || response.code() == 503 -> {
                return NetworkHelper.Message(response.message())
            }
            else -> {
                return NetworkHelper.Message("An Unexpected Error Occured")
            }
        }
    }
}