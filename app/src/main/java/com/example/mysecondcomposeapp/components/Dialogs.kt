package com.example.mysecondcomposeapp.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DisplayMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TimePicker
import androidx.compose.material3.TimePickerDefaults
import androidx.compose.material3.TimePickerLayoutType
import androidx.compose.material3.TimePickerState
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.SecureFlagPolicy
import com.example.mysecondcomposeapp.components.model.PokemonCombat
import java.util.Calendar

@Composable
fun MyDialogs(modifier: Modifier = Modifier) {
    var showDialog: Boolean by remember { mutableStateOf(true) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = { Button(onClick = { showDialog = false }) { Text("Confirmar") } },
            dismissButton = { Button(onClick = { showDialog = false }) { Text("Cancelar") } },
            title = { Text("Essa é a minha descriçãos") },
            text = { Text("Quer fazer essa ação?") },
            icon = { Icon(modifier = Modifier.size(53.dp),
                imageVector = Icons.Default.Info,
                contentDescription = null
            ) },
            shape = RoundedCornerShape(12),
            containerColor = Color.White,
            iconContentColor = Color.Red,
            titleContentColor = Color.Red,
            textContentColor = Color.Red,
            tonalElevation = 12.dp,
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
                securePolicy = SecureFlagPolicy.SecureOn,
                usePlatformDefaultWidth = true,
                decorFitsSystemWindows = true
                )
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun MyDateDialog(modifier: Modifier = Modifier) {
    var showDialog: Boolean by remember {mutableStateOf(true) }

    val calendar: Calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR,+ 1)
    calendar.set(Calendar.MONTH, Calendar.JANUARY)

    val datePickerSate: DatePickerState = rememberDatePickerState(
        initialSelectedDateMillis = calendar.timeInMillis,
        initialDisplayedMonthMillis = calendar.timeInMillis,
        yearRange = 2024..2030,
        initialDisplayMode = DisplayMode.Picker,
        selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                val filterCalendar: Calendar =
                    Calendar.getInstance().apply { timeInMillis = utcTimeMillis }
                val day: Int = filterCalendar.get(Calendar.DAY_OF_MONTH)
                return day % 2 == 0
            }
        }

    )

    if(showDialog) {
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                Button(onClick = { showDialog = false
                val result = datePickerSate.selectedDateMillis
                    if (result != null) {
                        val newCalendar = Calendar.getInstance().apply { timeInMillis = result}
                        val day = newCalendar.get(Calendar.DAY_OF_MONTH)
                        val month = newCalendar.get(Calendar.MONTH) + 1
                        Log.i("Data selecionada","Dia: $day, Mês: $month")
                    }
                }) { Text("Confirmar") }
            }){
            DatePicker(state = datePickerSate)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
@Composable
fun MyTimePicker(modifier: Modifier = Modifier) {
    var showTimerPicker: Boolean by remember { mutableStateOf(true) }
    val timePickerState: TimePickerState = rememberTimePickerState(
        initialHour = 7,
        initialMinute = 33,
        is24Hour = false
    )

    if (showTimerPicker) {
        Dialog(
            onDismissRequest = { showTimerPicker = false },

        ) {
            Column(modifier = Modifier
                .background(color = Color.White)
                .padding(24.dp))  {
                TimePicker( timePickerState,
                            layoutType = TimePickerLayoutType.Vertical,
                            colors = TimePickerDefaults.colors(
                                clockDialColor = Color.Red,
                                clockDialSelectedContentColor = Color.Red,
                                selectorColor = Color.White,
                                clockDialUnselectedContentColor = Color.White,
                                containerColor = Color.White,
                                periodSelectorBorderColor = Color.Red,
                                periodSelectorUnselectedContentColor = Color.White,
                                periodSelectorSelectedContainerColor = Color.White,
                                periodSelectorSelectedContentColor = Color.Red,
                                periodSelectorUnselectedContainerColor = Color.Red,
                                timeSelectorSelectedContainerColor = Color.Red,
                                timeSelectorSelectedContentColor = Color.White,
                                timeSelectorUnselectedContentColor = Color.Red,
                                timeSelectorUnselectedContainerColor = Color.White,
                            )
                    )
                Row {
                    TextButton(
                        onClick = { showTimerPicker = false },
                        modifier = Modifier.padding(end = 60.dp),
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.Red,
                        ),
                    ) {
                        Text("Cancelar")
                    }

                    TextButton(
                        onClick = { showTimerPicker = false },
                        modifier = Modifier.padding(start = 30.dp),
                        shape = RoundedCornerShape(50),
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = Color.White,
                            containerColor = Color.Red
                        ),

                        ) {
                        Text("Confirmar")
                    }
                }
            }
        }
    }
}


@Composable
fun MyCustomDialog(
    modifier: Modifier = Modifier,
    pokemonCombat: PokemonCombat,
    showDialog: Boolean,
    onStartCombat: () -> Unit,
    onDismissDialog: () -> Unit
) {
    if (showDialog){
        Dialog(onDismissRequest = { onDismissDialog() }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .background(color = Color.White,
                        shape = RoundedCornerShape(24)),
                horizontalAlignment = Alignment.CenterHorizontally


                ){
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                    horizontalArrangement = Arrangement.Center) {
                    Text(text = pokemonCombat.pokemonA, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = "VS")
                    Spacer(modifier = Modifier.size(16.dp))
                    Text(text = pokemonCombat.pokemonB, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                }
                Button(onClick = { onStartCombat()})  {
                    Text("Lutar")
                }
                Button(onClick = { onDismissDialog()})  {
                    Text("Fechar")
                }
            }
        }
    }
}