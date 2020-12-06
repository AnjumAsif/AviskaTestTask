package com.asif.aviskatesttask

import android.content.Context
import android.widget.Toast

class Utils {
    companion object {

        //show short toast message
        fun showToast(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }
}