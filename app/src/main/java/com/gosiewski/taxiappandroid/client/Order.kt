package com.gosiewski.taxiappandroid.client

data class Order(val id: Long, val lattitude: Double, val langtitude: Double, val acceptedBy: String, val user: String, val finished: Boolean)