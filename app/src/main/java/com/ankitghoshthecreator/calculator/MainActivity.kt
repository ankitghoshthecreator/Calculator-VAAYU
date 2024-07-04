package com.ankitghoshthecreator.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ankitghoshthecreator.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var value1 = remember {
        mutableStateOf("")
    }
    var value2 = remember {
        mutableStateOf("")
    }
    var reasult = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(value = value1.value, onValueChange = {
            value1.value = it
        }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(30.dp))


        OutlinedTextField(value = value2.value, onValueChange = {
            value2.value=it
        }, modifier = Modifier.fillMaxWidth())
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                reasult.value= (value1.value.toDouble() + value2.value.toDouble()).toString()
            }) {
                Text(text = "+")
            }
            Button(onClick = {
                reasult.value= (value1.value.toDouble() - value2.value.toDouble()).toString()
            }) {
                Text(text = "-")
            }

        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            Button(onClick = {
                reasult.value= (value1.value.toDouble() * value2.value.toDouble()).toString()
            }) {
                Text(text = "x")
            }
            Button(onClick = {
                reasult.value= (value1.value.toDouble() / value2.value.toDouble()).toString()
            }) {
                Text(text = "/")
            }

        }
        if (reasult.value.isNotEmpty())
        Text(text = "Reasult ${reasult.value}")

    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    CalculatorTheme {
        MyApp()
    }
}