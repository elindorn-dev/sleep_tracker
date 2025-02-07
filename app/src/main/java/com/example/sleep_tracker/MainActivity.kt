package com.example.sleep_tracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sleep_tracker.ui.screens.MainScreen
import com.example.sleep_tracker.ui.screens.SplashScreen
import com.example.sleep_tracker.ui.theme.Sleep_trackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Sleep_trackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
                        NavigationScreens()
                    }
                }
            }
        }
    }
}
@Composable
fun NavigationScreens() {
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination = "splash_screen") {
        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen") {
            MainScreen()
        }
    }
}