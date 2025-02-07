package com.example.sleep_tracker.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sleep_tracker.R

@Composable
fun App_title(modifier: Modifier = Modifier) {
    Row {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.app_title),
            contentDescription = ""
        )
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.sleep_moon),
            contentDescription = ""
        )
    }
}

@Preview
@Composable
private fun App_title_prev() {
    
}