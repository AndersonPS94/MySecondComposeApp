package com.example.mysecondcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mysecondcomposeapp.components.animations.MyAnimatedVisibility
import com.example.mysecondcomposeapp.components.MyCustomDialog
import com.example.mysecondcomposeapp.components.animations.FullAnimateAsState
import com.example.mysecondcomposeapp.components.animations.MyAnimateContent
import com.example.mysecondcomposeapp.components.animations.MyContentSize
import com.example.mysecondcomposeapp.components.animations.MyCrossfade
import com.example.mysecondcomposeapp.components.animations.MyInfinityTransition
import com.example.mysecondcomposeapp.components.model.PokemonCombat

import com.example.mysecondcomposeapp.ui.theme.MySecondComposeAppTheme

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
                MyInfinityTransition()
                //MyContentSize()
                //MyAnimateContent()
            //MyCrossfade()
               // FullAnimateAsState()
                //MyAnimatedVisibility()
                //NavigationWrapper()
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