package com.example.sleep_tracker.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.sleep_tracker.ui.components.App_title
import com.example.sleep_tracker.ui.theme.Sleep_trackerTheme

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Box(
    modifier = Modifier.fillMaxSize()
        .background(
            brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF08070F),
                    Color(0xFF10059F)
                )
            )
        )
    ) {
        Column() {

        }
    }
}