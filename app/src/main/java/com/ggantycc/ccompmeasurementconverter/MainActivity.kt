package com.ggantycc.ccompmeasurementconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                        onValueChange = { newText -> text = newText.filter { it.isDigit() } },
                        label = { Text("Value") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row() {
                        Button(
                            onClick = {
                                val inputValue = text.toDoubleOrNull()
                                if (inputValue != null) {
                                    convertedValue = (text.toDouble() * 0.621371).toString()
                                } else {
                                    convertedValue = "Invalid input"
                                }
                            }
                        ) {
                            Text("km -> miles")
                        }
                        Button(
                            onClick = {
                                val inputValue = text.toDoubleOrNull()
                                if (inputValue != null) {
                                    convertedValue = (text.toDouble() * 1093.61).toString()
                                } else {
                                    convertedValue = "Invalid input"
                                }
                            }
                        ) {
                            Text("km -> yard")
                        }
                        Button(
                            onClick = {
                                val inputValue = text.toDoubleOrNull()
                                if (inputValue != null) {
                                    convertedValue = (text.toDouble() * 3280.84).toString()
                                } else {
                                    convertedValue = "Invalid input"
                                }
                            }
                        ) {
                            Text("km -> foot")
                        }
                    }
                    Row() {
                        Button(
                            onClick = {
                                val inputValue = text.toDoubleOrNull()
                                if (inputValue != null) {
                                    convertedValue = (text.toDouble() * 1.60934).toString()
                                } else {
                                    convertedValue = "Invalid input"
                                }
                            }
                        ) {
                            Text("miles -> km")
                        }
                        Button(
                            onClick = {
                                val inputValue = text.toDoubleOrNull()
                                if (inputValue != null) {
                                    convertedValue = (text.toDouble() * 1760).toString()
                                } else {
                                    convertedValue = "Invalid input"
                                }
                            }
                        ) {
                            Text("miles -> yd")
                        }
                        Button(
                            onClick = {
                                val inputValue = text.toDoubleOrNull()
                                if (inputValue != null) {
                                    convertedValue = (text.toDouble() * 5280).toString()
                                } else {
                                    convertedValue = "Invalid input"
                                }
                            }
                        ) {
                            Text("miles -> ft")
                        }
                    }
                    Text(convertedValue, style = TextStyle(
                        color = Color.Blue, fontWeight = FontWeight.Bold, fontSize = 30.sp
                    ))
                }
            }
        }
    }
}