package com.example.sleep_tracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sleep_tracker.ui.components.App_title
import com.example.sleep_tracker.ui.components.ScrollingDateSelector
import com.example.sleep_tracker.ui.theme.Sleep_trackerTheme

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Box(contentAlignment = Alignment.Center,
    modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF08070F),
                    Color(0xFF10059F)
                )
            )
        )
    ) {
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.35f)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF10059F),
                            Color(0xFF1A0126)
                        )
                    )
                )
                .drawWithContent {
                    drawContent()
                    val strokeWidth = 5.dp.toPx()
                    val lineColor = Color(0xFF9900FF)
                    drawLine(
                        color = lineColor,
                        start = Offset(0f, size.height),
                        end = Offset(size.width, size.height),
                        strokeWidth = strokeWidth
                    )
                    drawLine(
                        color = lineColor,
                        start = Offset(0f, 0f),
                        end = Offset(size.width, 0f),
                        strokeWidth = strokeWidth
                    )
                }
                .padding(top = 30.dp)
        ) {
            Text(
                modifier = Modifier
                    .offset(14.dp, -12.dp),
                text = "ч",
                color = Color.White
            )
            Box (
                modifier = Modifier
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth(0.9f)
                    //.align(Alignment.TopCenter)
                    .offset(18.dp, 10.dp)
                    .drawWithContent {
                        drawContent()
                        val strokeWidth = 1.dp.toPx()
                        val lineColor = Color.White
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = strokeWidth
                        )
                        drawLine(
                            color = lineColor,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = strokeWidth
                        )
                    }
                //.background(Color.White)
                //.padding(start = 62.dp, top = 20.dp)
            )
            ScrollingDateSelector()
        }
    }
}

@Preview
@Composable
private fun Main_prev() {
    MainScreen()
}