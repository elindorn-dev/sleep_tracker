package com.example.sleep_tracker.ui.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.sleep_tracker.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(1f).getInterpolation(it)
                }))
        delay(3000L)
        navController.navigate("main_screen")
    }
    Box(contentAlignment = Alignment.Center,
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
        Image(painter = painterResource(id = R.drawable.splashscreen),
            contentDescription = "Logo",
            modifier = Modifier.scale(scale.value).fillMaxSize())
    }
}