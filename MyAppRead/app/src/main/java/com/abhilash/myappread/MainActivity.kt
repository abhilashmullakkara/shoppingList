package com.abhilash.myappread

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.abhilash.myappread.navigation.ReaderNavigation
import com.abhilash.myappread.ui.theme.MyAppReadTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppReadTheme {
                // A surface container using the 'background' color from the theme
               ReaderApp()
            }
        }
    }
}

@Composable
fun ReaderApp(){
    Surface(
        color = Color(color = 0xFFFFFFFF),
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            ReaderNavigation()
        }

    }

}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppReadTheme {

    }
}