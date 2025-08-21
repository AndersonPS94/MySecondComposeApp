package com.example.mysecondcomposeapp.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.mysecondcomposeapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyExposedDropDownMenu(modifier: Modifier = Modifier) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    var selectedText: String by remember { mutableStateOf("Selecione uma opção") }

    ExposedDropdownMenuBox(modifier = modifier, expanded = expanded, onExpandedChange = { expanded = !expanded }) {

        TextField(value = selectedText,
            readOnly = true,
            onValueChange = { },
            label = { Text(text = "Idioma") },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth(),
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            }
        )
        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false },) {
            DropdownMenuItem(text = { Text(text = "Inglês") }, onClick = {
                selectedText = "Inglês"
                expanded = false})
            DropdownMenuItem(text = { Text(text = "Espanhol") }, onClick = {
                selectedText = "Espanhol"
                expanded = false})
            DropdownMenuItem(text = { Text(text = "Francês") }, onClick = {
                selectedText = "Francês"
                expanded = false})
            DropdownMenuItem(text = { Text(text = "Alemão") }, onClick = {
                selectedText = "Alemão"
                expanded = false})
            DropdownMenuItem(text = { Text(text = "Português") }, onClick = {
                selectedText = "Português"
                expanded = false})

        }
    }
}

@Composable
fun MyDropDownMenu(modifier: Modifier = Modifier) {
    var expanded: Boolean by remember { mutableStateOf(false) }
    Box (modifier = modifier)  {
        Button(onClick = { expanded = !expanded }) {
            Text(text = "Mostrar menu")
        }
        DropdownMenu(expanded = expanded,
            onDismissRequest = { expanded = false },
            offset = DpOffset(16.dp, 16.dp),
            properties = PopupProperties(
                focusable = true,
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                clippingEnabled = false
            ),
        ) {
            DropdownMenuItem(text = { Text(text = "Item 1") }, onClick = {expanded = false})
            DropdownMenuItem(text = { Text(text = "Item 2") }, onClick = {expanded = false})
            DropdownMenuItem(text = { Text(text = "Item 3") }, onClick = {expanded = false})
            DropdownMenuItem(text = { Text(text = "Item 4") }, onClick = {expanded = false})
            DropdownMenuItem(text = { Text(text = "Item 5") }, onClick = {expanded = false})
            DropdownMenuItem(text = { Text(text = "Item 6") }, onClick = {expanded = false})
        }
    }
}


@Composable
fun MyDropDownItem(modifier: Modifier = Modifier, text: String) {
    Column (modifier = modifier)  {
        DropdownMenuItem(modifier = Modifier.fillMaxWidth(),
            text =
                    { Text(text) },
            leadingIcon = {
                Icon(painter = painterResource(R.drawable.ic_personita_24),
                    contentDescription = "") },
            trailingIcon = {
                Icon(painter = painterResource(R.drawable.ic_personita_24),
                    contentDescription = "") },
            onClick = { /*TODO*/ },
            enabled = true,
            contentPadding = PaddingValues(16.dp),
            colors = MenuDefaults.itemColors(
                textColor = Color.Red,
                leadingIconColor = Color.Blue,
                trailingIconColor = Color.Green,
                disabledTextColor = Color.Red,
                disabledLeadingIconColor = Color.Blue,
                disabledTrailingIconColor = Color.Green,
            )
        )
    }
}