package com.gosiewski.taxiappandroid.client

import android.view.View
import com.gosiewski.taxiappandroid.BaseViewHolder
import kotlinx.android.synthetic.main.viewholder_client_order.view.*

class ClientOrderHolder(itemView: View, private val deleteAction: (id: Long) -> Unit, private val finishAction: (id: Long) -> Unit, private val showAction: (lat: Double, lang: Double) -> Unit)
    : BaseViewHolder<Order>(itemView) {

    override fun bind(item: Order) {
        super.bind(item)

        itemView.orderNumberTextView.text = "Order number " + item.id
        itemView.orderDestinationTextView.text = "Destination: Lat-" + item.lattitude + " Lang-" + item.langtitude
        itemView.orderClientTextView.text = "Ordered by " + item.user

        if (item.acceptedBy.isEmpty()) {
            itemView.orderAcceptedTextView.text = "Waiting for driver accept"
            itemView.finishButton.visibility = View.GONE
            itemView.cancelButton.visibility = View.VISIBLE
        } else {
            itemView.orderAcceptedTextView.text = "Accepted by " + item.acceptedBy
            itemView.finishButton.visibility = View.VISIBLE
            itemView.cancelButton.visibility = View.GONE
        }

        itemView.cancelButton.setOnClickListener({ deleteAction.invoke(currentItem!!.id) })
        itemView.finishButton.setOnClickListener({ finishAction.invoke(currentItem!!.id) })
        itemView.setOnClickListener({ showAction.invoke(currentItem!!.lattitude, currentItem!!.langtitude) })
    }
}