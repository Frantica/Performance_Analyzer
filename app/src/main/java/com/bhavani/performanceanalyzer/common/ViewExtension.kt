package com.bhavani.performanceanalyzer.common

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(msg: String, length: Int = Snackbar.LENGTH_SHORT) {
    Snackbar.make(this, msg, length).show()
}