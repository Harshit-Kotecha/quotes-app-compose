package com.example.quotes

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import com.example.quotes.models.Quote
import com.google.gson.Gson
import java.io.IOException
import java.io.InputStream


object DataManager {
    var quotes = mutableStateListOf<Quote>()

    fun loadData(context: Context): Unit {
        try {
            val `is`: InputStream = context.assets.open("quotes.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            val jsonString = String(buffer, charset("UTF-8"))
            val data = Gson().fromJson<Array<Quote>>(jsonString, Array<Quote>::class.java)
            Log.i("file", jsonString)
            quotes.addAll(data)
        } catch (e: IOException) {
            Log.e("file", e.toString())
            e.printStackTrace()
        }

    }
}