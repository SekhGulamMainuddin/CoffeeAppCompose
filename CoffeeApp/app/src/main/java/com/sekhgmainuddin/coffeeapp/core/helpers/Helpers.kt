package com.sekhgmainuddin.coffeeapp.core.helpers

fun Double.format(digits: Int) = "%.${digits}f".format(this)