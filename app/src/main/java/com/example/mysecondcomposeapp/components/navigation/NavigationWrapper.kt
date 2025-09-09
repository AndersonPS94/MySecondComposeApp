package com.example.mysecondcomposeapp.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.mysecondcomposeapp.components.navigation.examples.DetailScreen
import com.example.mysecondcomposeapp.components.navigation.examples.HomeScreen
import com.example.mysecondcomposeapp.components.navigation.examples.LoginScreen
import com.example.mysecondcomposeapp.components.navigation.examples.SettingScreen
import com.example.mysecondcomposeapp.components.navigation.examples.model.SettingModel
import com.example.mysecondcomposeapp.components.navigation.types.createNavType
import com.example.mysecondcomposeapp.components.navigation.types.settingsModelType
import kotlin.reflect.typeOf


@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Login) {
        composable <Login> {
            LoginScreen(navigateToDetail = {navController.navigate(Home)})

        }
        composable <Home> {
            HomeScreen(navigateBack = {navController.popBackStack()},
                navigateToDetail = {id, x -> navController.navigate(Detail(id, x))})
        }

        composable<Detail> { navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(id = detail.id, navigateToSettings = {navController.navigate(Settings(it))})
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingModel>()to createNavType<SettingModel>())) { navBackStackEntry ->
            val setting = navBackStackEntry.toRoute<Settings>()
            SettingScreen(setting.settingsModel, navigateToHome = {
                  navController.navigate(Login){
                    popUpTo<Login>{inclusive = true}
                }
            })
        }
    }
}
