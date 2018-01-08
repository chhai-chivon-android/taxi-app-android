package com.gosiewski.taxiappandroid.client

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.location.LocationManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.gosiewski.taxiappandroid.Application
import com.gosiewski.taxiappandroid.R
import com.gosiewski.taxiappandroid.splash.SplashActivity
import com.gosiewski.taxiappandroid.utils.AuthInfoStorage
import kotlinx.android.synthetic.main.activity_client_main.*
import javax.inject.Inject







class ClientMainActivity : AppCompatActivity(), ClientMainView {
    @Inject lateinit var presenter: ClientMainPresenter
    @Inject lateinit var authInfoStorage: AuthInfoStorage
    private lateinit var adapter: ClientOrdersAdapter

    companion object {
        fun newInstance(context: Context) : Intent {
            return Intent(context, ClientMainActivity::class.java)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_client_main)
        (application as Application).getComponent(applicationContext).inject(this)
        presenter.bindView(this)

        adapter = ClientOrdersAdapter(presenter::deleteOrder, presenter::finishOrder)

        ordersRecyclerView.setHasFixedSize(true)
        ordersRecyclerView.layoutManager = LinearLayoutManager(this)
        ordersRecyclerView.adapter = adapter

        fabRefresh.setOnClickListener({ presenter.start() })
        fabAdd.setOnClickListener({
            val lm = getSystemService(Context.LOCATION_SERVICE) as LocationManager
            val location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            val longitude = location.longitude
            val latitude = location.latitude
            presenter.addOrder(latitude, longitude)
        })

        presenter.start()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_action_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> {
                authInfoStorage.clear()
                startActivity(SplashActivity.newInstance(this))
            }
        }
        return true
    }

    override fun showOrders(orders: List<Order>) {
        adapter.setOrders(orders)
    }
}
