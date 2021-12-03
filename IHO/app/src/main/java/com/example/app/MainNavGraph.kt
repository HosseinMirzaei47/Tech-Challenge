package com.example.app

import androidx.compose.material.ScaffoldState
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.app.shared.Screens
import com.example.app.home.HomeScreen

const val MAIN_NAV_GRAPH_ROUTE = "main"

fun NavGraphBuilder.mainNavGraph(navController: NavController, scaffoldState: ScaffoldState) {
    navigation(startDestination = Screens.Home.route, route = MAIN_NAV_GRAPH_ROUTE) {
        composable(route = Screens.Home.route) { HomeScreen(navController, scaffoldState) }
    }
}
