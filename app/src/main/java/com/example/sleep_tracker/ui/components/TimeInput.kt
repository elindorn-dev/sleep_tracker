package com.example.timepicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.time.Duration
import java.time.LocalTime

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePicker() {
    var time1 by remember {
        mutableStateOf(LocalTime.of(9, 0))
    }

    var time2 by remember {
        mutableStateOf(LocalTime.of(18, 0))
    }

    var showPicker1 by remember {
        mutableStateOf(false)
    }

    var showPicker2 by remember {
        mutableStateOf(false)
    }

    val difference = remember(time1, time2) {
        var duration = Duration.between(time1, time2)

        if (duration.isNegative) {
            duration = duration.plusHours(24)
        }

        duration
    }

    val hours = difference.toHours()
    val minutes = difference.toMinutes() % 60

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 20.dp),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    showPicker1 = true
                }
            ) {
                Text("Время отбоя: ${time1.formatTime()}")
            }

            Button(
                onClick = {
                    showPicker2 = true
                }
            ) {
                Text("Время подъема: ${time2.formatTime()}")
            }
        }
    }

    if (showPicker1) {
        TimePickerDialog(
            initialTime = time1,
            onDismiss = {
                showPicker1 = false
            },
            onConfirm = { selectedTime ->
                time1 = selectedTime
                showPicker1 = false
            }
        )
    }

    if (showPicker2) {
        TimePickerDialog(
            initialTime = time2,
            onDismiss = {
                showPicker2 = false
            },
            onConfirm = { selectedTime ->
                time2 = selectedTime
                showPicker2 = false
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TimePickerDialog(
    initialTime: LocalTime,
    onDismiss: () -> Unit,
    onConfirm: (LocalTime) -> Unit
) {
    val timePickerState = rememberTimePickerState(
        initialHour = initialTime.hour,
        initialMinute = initialTime.minute,
        is24Hour = true
    )

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(
                onClick = {
                    onConfirm(
                        LocalTime.of(
                            timePickerState.hour,
                            timePickerState.minute
                        )
                    )
                }
            ) {
                Text("Сохранить")
            }
        },
        dismissButton = {
            Button(
                onClick = onDismiss
            ) {
                Text("Отмена")
            }
        },
        text = {
            TimePicker(
                state = timePickerState
            )
        }
    )
}

fun LocalTime.formatTime(): String {
    return "%02d:%02d".format(hour, minute)
}
@Preview
@Composable
fun TimePickerDialogPreview() {
    MaterialTheme {
        TimePickerDialog(
            initialTime = LocalTime.of(12, 30),
            onDismiss = {},
            onConfirm = {}
        )
    }
}