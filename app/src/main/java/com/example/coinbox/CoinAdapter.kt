package com.example.coinbox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.data.Coins
import com.example.data.CoinsItem

class CoinAdapter : ListAdapter<CoinsItem,CoinAdapter.CoinVerHolder>(Differ){
    object Differ : DiffUtil.ItemCallback<CoinsItem>(){
        override fun areItemsTheSame(oldItem: CoinsItem, newItem: CoinsItem): Boolean {
            return  oldItem.id === newItem.id
        }

        override fun areContentsTheSame(oldItem: CoinsItem, newItem: CoinsItem): Boolean {
            return  oldItem.id == newItem.id
        }

    }

    class CoinVerHolder(var view : View) : RecyclerView.ViewHolder(view){
        var coinname = view.findViewById<TextView>(R.id.coin_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinVerHolder {
        return CoinVerHolder(LayoutInflater.from(parent.context).inflate(R.layout.coin_item,parent,false))
    }

    override fun onBindViewHolder(holder: CoinVerHolder, position: Int) {
        var curItem = getItem(position)
        holder.coinname.text = curItem.name
    }
}