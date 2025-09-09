package com.example.mysecondcomposeapp.components

import android.R.id.list
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random


@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick:(String)-> Unit) {
    val names = listOf(
        "Android",
        "Jetpack",
        "Compose",
        "Android",
        "Jetpack",
        "Compose",
        "Android",
        "Jetpack",
        "Compose",
        "Android",
        "Jetpack",
        "Compose",
        "Android",
        "Jetpack",
        "Compose",
        "Android",
        "Jetpack",
        )

    LazyRow (modifier = modifier) {
        items(names, key = { myValue -> myValue }) { MyValue ->
            Text(
                text = MyValue,
                modifier = Modifier
                    .padding(24.dp)
                    .clickable { onItemClick(MyValue) })
        }
    }
}


@Composable
fun MyAdvanceList(modifier: Modifier = Modifier) {
    var items: List<String> by remember {mutableStateOf(List(100){"Item nómero $it"}) }

    LazyColumn(modifier = modifier){
        item{
            Button({
                items = items.toMutableList().apply {
                    add(0,"Novo Item")}}
            ) {
                Text("Adicionar Item")
            }
        }
        itemsIndexed(items, key = { _, item -> item }) {index, item ->
            Row {
                Text(item + "   indice: $index")
                Spacer(modifier = Modifier.weight(1f))
                TextButton({
                    items = items.toMutableList().apply {
                        remove(item)
                        //removeAt(index)
                    }
                }) {
                    Text("Remover")
                Spacer(modifier = Modifier.width(24.dp))
                }
            }
        }
    }
}

@Composable
fun ScrollList(modifier: Modifier = Modifier) {
    val lisState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf { lisState.firstVisibleItemIndex > 5 }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.TopEnd){
        LazyColumn(state = lisState) {
            items(100){
                Text("Item $it", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            }
        }
        if (showButton) {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    //lisState.animateScrollToItem(0)
                    lisState.scrollToItem(0)
                }
            }, modifier = Modifier.padding(16.dp)
            ){
                Icon(imageVector = Icons.Default.Home,contentDescription = null)
            }
        }
    }
}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val numbers = remember {
        mutableStateOf(List(50){
            Random.nextInt(0, 6)
        }) }
    val colos = listOf(
        Color(0xFFE57373),
        Color(0xFFFFB74D),
        Color(0xFFFFF176),
        Color(0xFF81C784),
        Color(0xFF64B5F6),
        Color(0xFFBA68C8),
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)

    ) {
        items(numbers.value) { randomNumber ->
            Box(
                modifier = Modifier
                    .background(colos[randomNumber]).height(80.dp),
                contentAlignment = Alignment.Center
            ){
                Text(text = randomNumber.toString(),color = Color.White,fontSize = 28.sp)
            }
        }
    }
}