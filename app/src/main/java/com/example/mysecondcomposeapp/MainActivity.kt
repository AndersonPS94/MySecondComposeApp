package com.example.mysecondcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.mysecondcomposeapp.components.MyAdvanceList
import com.example.mysecondcomposeapp.components.MyBasicList
import com.example.mysecondcomposeapp.components.MyCustomDialog
import com.example.mysecondcomposeapp.components.MyDateDialog
import com.example.mysecondcomposeapp.components.MyDialogs
import com.example.mysecondcomposeapp.components.MyFAB
import com.example.mysecondcomposeapp.components.MyGridList
import com.example.mysecondcomposeapp.components.MyModalDrawer
import com.example.mysecondcomposeapp.components.MyNavigationBar
import com.example.mysecondcomposeapp.components.MyTimePicker
import com.example.mysecondcomposeapp.components.MyTopAppBar
import com.example.mysecondcomposeapp.components.ScrollList
import com.example.mysecondcomposeapp.components.advance.InteractionSourceExample
import com.example.mysecondcomposeapp.components.advance.MyDerivadSateteOf
import com.example.mysecondcomposeapp.components.advance.MyLaunchedEffect
import com.example.mysecondcomposeapp.components.model.PokemonCombat
import com.example.mysecondcomposeapp.components.navigation.NavigationWrapper

import com.example.mysecondcomposeapp.ui.theme.MySecondComposeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MySecondComposeAppTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val snackBarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                var showDialog: Boolean by remember { mutableStateOf(false) }
                val pokemonCombat = PokemonCombat("Pikachu", "Gengar")


                MyCustomDialog(
                    showDialog = showDialog,
                    pokemonCombat = pokemonCombat,
                    onStartCombat = {
                        //iniciar combate
                        showDialog = false
                    },
                    onDismissDialog = {showDialog = false})

                NavigationWrapper()
                /*MyModalDrawer (drawerState){

                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = { MyTopAppBar{ scope.launch { drawerState.close() } } },
                        snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
                        floatingActionButton = {MyFAB{showDialog = true}},
                    floatingActionButtonPosition = FabPosition.Center,
                        bottomBar = { MyNavigationBar() }
                    )
                    { innerPadding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(innerPadding)
                                .background(color = Color.Cyan),
                            contentAlignment = Alignment.Center
                        ) {*//*
                            Text("Esta é minha tela", modifier = Modifier.clickable {
                                scope.launch {
                                    val result = snackBarHostState.showSnackbar(
                                        message = "Obrigado por clicar",
                                        actionLabel = "Ok"
                                    )

                                    if (result == SnackbarResult.ActionPerformed) {

                                        //apertou desfazer

                                    } else {

                                        //não apertou desfazer

                                    }
                                }
                            })*//*
                            //InteractionSourceExample()
                            //MyLaunchedEffect(onFinished = {})
                            //MyDerivadSateteOf()
                            //MyBasicList(onItemClick = {})
                            //MyAdvanceList()
                            //ScrollList()
                            //MyGridList()
                        }
                    }
                }*/
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MySecondComposeAppTheme {
        Greeting("Android")
    }
}