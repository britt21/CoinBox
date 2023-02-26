package com.example.data

open class NetworkHelper<T>(var data : T? = null, var message : String? = null) {



    class Success<T>(data: T,message: String? = null): NetworkHelper<T>(data, message)
    class Message<T>(message: String,data: T? = null): NetworkHelper<T>(data,message)
    class Loading<T>: NetworkHelper<T>()




}