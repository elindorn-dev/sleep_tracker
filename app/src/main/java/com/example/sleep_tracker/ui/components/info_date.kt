package com.example.sleep_tracker.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import java.time.LocalDate
import java.time.Year
import java.time.format.DateTimeFormatter

@Composable
fun ScrollingDateSelector() {
    val dates = remember { generateDates() } // Generate a list of dates
    val scrollState = rememberScrollState()

    Row(
        modifier = Modifier
            .horizontalScroll(scrollState)
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.Top // Align items to the top
    ) {
        dates.forEach { date ->
            DateItem(date = date)
        }
    }
}

@Composable
fun DateItem(date: LocalDate) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .background(Color.LightGray)
        )
        Text(
            text = date.format(DateTimeFormatter.ofPattern("dd.MM")),
            color = Color.White,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

fun generateDates(): List<LocalDate> {
    val startDate = Year.now().atDay(1)
    return List(365) { startDate.plusDays(it.toLong()) }
}

@Preview
@Composable
fun PreviewScrollingDateSelector() {
    ScrollingDateSelector()
}