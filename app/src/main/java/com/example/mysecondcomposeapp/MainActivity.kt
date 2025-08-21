package com.example.mysecondcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mysecondcomposeapp.components.MyDropDownItem
import com.example.mysecondcomposeapp.components.MyDropDownMenu
import com.example.mysecondcomposeapp.components.MyExposedDropDownMenu
import com.example.mysecondcomposeapp.components.MyRadioButtonList
import com.example.mysecondcomposeapp.components.MyRangeSlider
import com.example.mysecondcomposeapp.components.MySlider
import com.example.mysecondcomposeapp.components.MySliderAdvance

import com.example.mysecondcomposeapp.ui.theme.MySecondComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySecondComposeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyExposedDropDownMenu(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySecondComposeAppTheme {
        Greeting("Android")
    }
}