package com.example.quotes.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.quotes.models.Quote

@Composable
fun QuoteList(data: MutableList<Quote>, onClick: (quote: Quote) -> Unit) {
    LazyColumn {
        items(data) {
            QuoteListItem(quote = it, onClick)
        }
    }
}