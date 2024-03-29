package com.abhilash.myappread.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.abhilash.myappread.navigation.ReaderScreen
import kotlinx.coroutines.delay

@Composable
fun ReaderSplashScreen(navController: NavController){
val scale=remember {
    Animatable(0f)
}
    LaunchedEffect(key1 = true ){
        scale.animateTo(targetValue = 0.9f,
        animationSpec = tween(durationMillis = 800, easing = {
            OvershootInterpolator(8f).getInterpolation(it)
        }))
        delay(2000L)
        navController.navigate(ReaderScreen.LoginScreen.name)
    }
   Surface(modifier = Modifier
       .padding(15.dp)
       .size(330.dp)
       .scale(scale.value),
       shape = CircleShape,
       color = Color.White,
       border = BorderStroke(width = 2.dp, color = Color.LightGray)
   ) {
       Column(
           modifier = Modifier.padding(1.dp),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment =Alignment.CenterHorizontally
       ) {
        ReaderLogo()
           Spacer(modifier = Modifier.height(15.dp))
           Text(
               text = "\"Read.Change.Yourself\"",
               style = MaterialTheme.typography.h5,
               color = Color.LightGray
           )
       }

   }

}

@Composable
 fun ReaderLogo(modifier: Modifier=Modifier) {
    Text(
        text = "A.Reader",
        modifier=modifier.padding(bottom = 16.dp),
        style = MaterialTheme.typography.h3,
        color = Color.Red.copy(alpha = 0.5f)
    )
}