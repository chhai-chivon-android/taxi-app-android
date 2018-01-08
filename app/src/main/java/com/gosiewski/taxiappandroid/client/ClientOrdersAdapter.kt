package com.gosiewski.taxiappandroid.client

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.gosiewski.taxiappandroid.R

class ClientOrdersAdapter()
    : RecyclerView.Adapter<ClientOrderHolder>() {
    private var orders: List<Order> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientOrderHolder {
        return ClientOrderHolder(LayoutInflater.from(parent.context).inflate(R.layout.viewholder_client_order,
                parent, false))
    }

    override fun onBindViewHolder(holder: ClientOrderHolder, position: Int) = holder.bind(orders[position])

    override fun getItemCount(): Int = orders.size

    fun setOrders(newOrders: List<Order>) {
        orders = newOrders
        notifyDataSetChanged()
    }
}