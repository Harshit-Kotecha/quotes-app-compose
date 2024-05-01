package com.example.quotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import com.example.quotes.models.Quote
import com.example.quotes.screens.QuoteDetail
import com.example.quotes.screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            DataManager.loadData(applicationContext)
        }
        val currentPage = mutableStateOf(Pages.LISTING)
        var currentQuote: Quote? = null

        fun switchPages(quote: Quote) {
            if (currentPage.value == Pages.LISTING) {
                currentPage.value = Pages.DETAIL
                currentQuote = quote
            } else {
                currentPage.value = Pages.LISTING
            }
        }

        setContent {
            if (currentPage.value == Pages.LISTING) {
                QuoteListScreen(data = DataManager.quotes) {
                    switchPages(it)
                }
            } else {
                currentQuote?.let {
                    QuoteDetail(quote = it) {
                        currentPage.value = Pages.LISTING
                    }
                }
            }
        }


    }
}


enum class Pages {
    LISTING, DETAIL
}