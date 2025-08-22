package com.example.mysecondcomposeapp.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mysecondcomposeapp.R
import com.example.mysecondcomposeapp.components.model.NavItem

@Composable
fun MyNavigationBar(modifier: Modifier = Modifier) {
    val listItems = listOf(
        NavItem(
            name = "Home",
            icon = Icons.Default.Home
        ),
        NavItem(
            name = "Listas",
            icon = Icons.Default.List
        ),
        NavItem(
            name = "Configurações",
            icon = Icons.Default.Build
        )
    )


        var selectedIndex by remember { mutableIntStateOf(0) }
        NavigationBar (
            modifier = modifier,
            containerColor = Color.Red,
            tonalElevation = 100.dp
        ){
            listItems.forEachIndexed { index, item ->
                AndersonDevItem(navItem = item, isSelected = index == selectedIndex){
                    selectedIndex = index

                }
            }
        }
    }


    @Composable
    fun RowScope.AndersonDevItem(navItem: NavItem, isSelected: Boolean, onItemClick: () -> Unit) {
        NavigationBarItem(
            selected = isSelected,
            onClick = { onItemClick( ) },
            icon = {
                Icon(
                    imageVector = navItem.icon,
                    contentDescription = navItem.name
                )
            },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.Red,
                selectedTextColor = Color.White,
                indicatorColor = Color.White,
                unselectedIconColor = Color.Black,
                unselectedTextColor = Color.Black
            ),
            label = {
                Text(text = navItem.name)
            }
        )
    }

@Preview
@Composable
fun MyNavigationBarPreview() {
    MyNavigationBar()
}