package com.example.quotes.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.quotes.R
import com.example.quotes.models.Quote
import com.example.quotes.ui.theme.poppins

@Composable
fun QuoteDetail(quote: Quote, onBack: () -> Unit) {
    BackHandler {
        onBack()
    }
    Box(
        contentAlignment = Alignment.Center, modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.sweepGradient(
                    colors = listOf(
                        Color.LightGray, Color.White
                    )
                )
            )
    ) {
        Card(
            elevation = CardDefaults.cardElevation(4.dp),
            colors = CardDefaults.cardColors(Color.White),
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = Modifier.padding(
                    horizontal = 24.dp, vertical = 32.dp
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_g), contentDescription = ""
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = quote.text,
                    style = MaterialTheme.typography.displaySmall,
                    fontFamily = poppins,
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Text(
                    text = quote.author,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Thin
                )
            }
        }
    }


}