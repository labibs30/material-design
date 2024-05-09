package com.example.materialdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.materialdesign.ui.theme.MaterialDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val usedWaterAmount = remember { mutableStateOf(200) } // Use mutableStateOf directly
                    val totalWaterAmount = 2400
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        WaterBottle(
                            totalWaterAmount = totalWaterAmount,
                            unit = "ml",
                            usedWaterAmount = usedWaterAmount.value, // Access value property
                            modifier = Modifier.width(250.dp)
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = "Total amount is : $$totalWaterAmount")
                        Row {
                            Button(onClick = {
                                if (usedWaterAmount.value < 2400) usedWaterAmount.value += 200
                            }) {
                                Text(text = "Drink")
                            }
                            Spacer(modifier = Modifier.width(20.dp))
                            Button(onClick = { usedWaterAmount.value = 0 }) {
                                Text(text = "Clear")
                            }
                        }
                    }
                }
            }
        }
    }
}