package com.example.mysecondcomposeapp.components.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp
import com.example.mysecondcomposeapp.R
import com.example.mysecondcomposeapp.components.state.CheckBoxState

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    var switchState: Boolean by remember { mutableStateOf(false) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Icon(
                    painter = painterResource(R.drawable.ic_personita_24),
                    contentDescription = ""
                )
            },
            enabled = false,
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                checkedTrackColor = Color.Green,
                uncheckedThumbColor = Color.Blue,
                uncheckedTrackColor = Color.Yellow,
                uncheckedBorderColor = Color.Magenta,
                checkedBorderColor = Color.Cyan,
                disabledCheckedThumbColor = Color.DarkGray,
                disabledCheckedTrackColor = Color.Gray,
                disabledUncheckedThumbColor = Color.LightGray,
                disabledUncheckedTrackColor = Color.White,
                disabledUncheckedBorderColor = Color.Black,
                disabledCheckedBorderColor = Color.Black,
            )
        )
    }
}

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    var checkBoxState by remember { mutableStateOf(false) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { checkBoxState = !checkBoxState }
        ) {
            Checkbox(
                checked = checkBoxState,
                onCheckedChange = { checkBoxState = it },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Blue,
                    checkmarkColor = Color.Yellow,
                    disabledCheckedColor = Color.DarkGray,
                    disabledUncheckedColor = Color.Gray,
                    disabledIndeterminateColor = Color.LightGray,
                )
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(text = "Aceito os termos de usuario")
        }
    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {
    var state by remember {
        mutableStateOf(
            listOf(
                CheckBoxState("termos", "Aceitar termos de uso"),
                CheckBoxState("Newsletter", "Receber a newsletter", true),
                CheckBoxState("atualizações", "Receber atualizações"),
            )
        )
    }

    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxWithText(checkBoxState = myState) {
                state = state.map {
                    if (it.id == myState.id) {
                        myState.copy(checked = !myState.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun CheckBoxWithText(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable { onCheckedChange(checkBoxState) }
    ) {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckedChange(checkBoxState) },
            enabled = true,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(checkBoxState.label)
    }
}

@Composable
fun TriStateCheckBoxDemo(modifier: Modifier = Modifier) {
    var parentState: ToggleableState by remember { mutableStateOf(ToggleableState.Off) }
    var child1: Boolean by remember { mutableStateOf(false) }
    var child2: Boolean by remember { mutableStateOf(false) }


    fun updateParentState() {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column(modifier = modifier) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    val newState: Boolean = parentState != ToggleableState.On
                    child1 = newState
                    child2 = newState
                    updateParentState()
                }
            )
            Text("Selecionar Todos")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(
                checked = child1,
                onCheckedChange = {
                    child1 = it
                    updateParentState()
                }
            )
            Text("Child 1")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(
                checked = child2,
                onCheckedChange = {
                    child2 = it
                    updateParentState()
                }
            )
            Text("Child 2")
        }
    }
}
