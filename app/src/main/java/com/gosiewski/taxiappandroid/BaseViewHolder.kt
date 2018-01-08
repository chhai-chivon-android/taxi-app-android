package com.gosiewski.taxiappandroid

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var currentItem: T? = null

    open fun bind(item: T) {
        currentItem = item
    }
}