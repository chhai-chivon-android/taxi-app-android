package com.gosiewski.taxiappandroid.client

import android.view.View
import com.gosiewski.taxiappandroid.BaseViewHolder
import kotlinx.android.synthetic.main.viewholder_client_order.view.*

class ClientOrderHolder(itemView: View)
    : BaseViewHolder<Order>(itemView) {

    override fun bind(item: Order) {
        super.bind(item)

        itemView.idTextView.text = item.id.toString()
    }
}