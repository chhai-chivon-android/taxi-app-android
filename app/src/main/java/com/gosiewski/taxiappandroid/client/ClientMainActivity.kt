package com.gosiewski.taxiappandroid.client

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.gosiewski.taxiappandroid.Application
import com.gosiewski.taxiappandroid.R
import kotlinx.android.synthetic.main.activity_client_main.*
import javax.inject.Inject

class ClientMainActivity : AppCompatActivity(), ClientMainView {
    @Inject lateinit var presenter: ClientMainPresenter
    private val adapter: ClientOrdersAdapter = ClientOrdersAdapter()

    companion object {
        fun newInstance(context: Context) : Intent {
            return Intent(context, ClientMainActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_main)
        (application as Application).getComponent(applicationContext).inject(this)
        presenter.bindView(this)

        ordersRecyclerView.setHasFixedSize(true)
        ordersRecyclerView.layoutManager = LinearLayoutManager(this)
        ordersRecyclerView.adapter = adapter

        fabRefresh.setOnClickListener({ presenter.start() })

        presenter.start()
    }

    override fun showOrders(orders: List<Order>) {
        adapter.setOrders(orders)
    }
}
