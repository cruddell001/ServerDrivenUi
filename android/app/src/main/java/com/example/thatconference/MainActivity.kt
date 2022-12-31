package com.example.thatconference

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.thatconference.models.Movie
import com.example.thatconference.repository.DataRepository
import com.example.thatconference.ui.navigation.TabBarHost
import com.example.thatconference.ui.theme.ThatConferenceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            ThatConferenceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TabBarHost(controller = navController)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var movies by remember { mutableStateOf<List<Movie>>(emptyList()) }

    LaunchedEffect(key1 = Unit) {
        movies = DataRepository.getRecentMovies()
    }
    Text(text = "found ${movies.size} movies")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ThatConferenceTheme {
        Greeting("Android")
    }
}