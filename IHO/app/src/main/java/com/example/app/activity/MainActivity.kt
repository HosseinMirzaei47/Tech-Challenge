package com.example.app.activity

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.app.MAIN_NAV_GRAPH_ROUTE
import com.example.app.mainNavGraph
import com.example.app.ui.LocalBackPressedDispatcher
import com.example.app.ui.theme.AppTheme
import com.example.app.ui.theme.PrimaryIndigo50
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val bottomSheetNavigator = rememberBottomSheetNavigator()
            val navController = rememberNavController(bottomSheetNavigator)

            // TODO: 11/3/21 Temporary. design needed.
            val statusBarColor = MaterialTheme.colors.PrimaryIndigo50
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setStatusBarColor(statusBarColor)
            }

            AppTheme {
                CompositionLocalProvider(
                    LocalBackPressedDispatcher provides onBackPressedDispatcher
                ) {
                    ProvideWindowInsets {
                        ScreenContainer(navController, bottomSheetNavigator, viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenContainer(
    navController: NavHostController,
    bottomSheetNavigator: BottomSheetNavigator,
    viewModel: MainViewModel
) {

    val scaffoldState = rememberScaffoldState()

    val destinationChange by rememberUpdatedState(
        NavController.OnDestinationChangedListener { _, destination, _ ->
            viewModel.updateCurrentNavRoute(destination.route)
        }
    )
    DisposableEffect(navController) {
        navController.addOnDestinationChangedListener(destinationChange)
        onDispose { navController.removeOnDestinationChangedListener(destinationChange) }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        ModalBottomSheetLayout(
            bottomSheetNavigator = bottomSheetNavigator,
            sheetShape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
            sheetBackgroundColor = MaterialTheme.colors.background
        ) {
            NavHost(
                navController = navController,
                startDestination = MAIN_NAV_GRAPH_ROUTE
            ) {
                mainNavGraph(navController, scaffoldState)
            }
        }

    }
}
