package com.example.coinbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.scopes.ActivityRetainedScoped

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var homeViewModel : HomeViewModel
    var coinAdapter = CoinAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        var adapter = findViewById<RecyclerView>(R.id.rv_coins)
        getAllCoins()
        homeViewModel.getAllCoins()


        adapter.adapter = coinAdapter

    }


    private fun getAllCoins(){
        homeViewModel.liveCoins.observe(this, Observer { coins ->
            coinAdapter.submitList(coins.data)
        })
    }
}