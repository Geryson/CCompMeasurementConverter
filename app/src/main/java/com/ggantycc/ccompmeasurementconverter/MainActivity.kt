package com.ggantycc.ccompmeasurementconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ggantycc.ccompmeasurementconverter.ui.theme.CCompMeasurementConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var text by remember { mutableStateOf("") }
            var convertedValue by remember { mutableStateOf("-") }
            CCompMeasurementConverterTheme {
                Column(modifier = Modifier.padding(30.dp)) {
                    OutlinedTextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("Value") },
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row() {
                        Button(
                            onClick = {
                                convertedValue = (text.toDouble() * 0.621371).toString()
                            }
                        ) {
                            Text("km -> miles")
                        }
                        Button(
                            onClick = {
                                convertedValue = (text.toDouble() * 3.28084).toString()
                            }
                        ) {
                            Text("km -> yard")
                        }
                        Button(
                            onClick = {
                                convertedValue = (text.toDouble() * 39.3701).toString()
                            }
                        ) {
                            Text("km -> foot")
                        }
                    }
                    Text(convertedValue)
                }
            }
        }
    }
}