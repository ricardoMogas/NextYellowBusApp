package com.main.nextyellowbusapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.main.nextyellowbusapp.core.AppNavigationActions
import com.main.nextyellowbusapp.core.AppRoute
import com.main.nextyellowbusapp.core.AppTopLevelDestination
import com.main.nextyellowbusapp.core.TOP_LEVEL_DESTINATIONS
import com.main.nextyellowbusapp.router.screens.NotificationScreen
import com.main.nextyellowbusapp.router.screens.TicketScreen
import com.main.nextyellowbusapp.router.screens.TravelScreen
import com.main.nextyellowbusapp.ui.theme.NextYellowBusAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NextYellowBusAppTheme {
                val navController = rememberNavController()
                val navigateAction = remember(navController) {
                    AppNavigationActions(navController)
                }
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val selectedDestination = navBackStackEntry?.destination?.route ?: AppRoute.TRAVEL

                AppContent(
                    navController = navController,
                    selectedDestination = selectedDestination,
                    navigateTopLevelDestination = navigateAction::navigateTo
                )
            }
        }
    }
}

@Composable
fun AppContent(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    selectedDestination: String,
    navigateTopLevelDestination: (AppTopLevelDestination) -> Unit
) {
    Row(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {
            NavHost(
                modifier = Modifier.weight(1f),
                navController = navController,
                startDestination = AppRoute.TRAVEL
            ) {
                composable(AppRoute.TRAVEL) {
                    TravelScreen()
                }
                composable(AppRoute.TICKET) {
                    TicketScreen()
                }
                composable(AppRoute.NOTIFICATION) {
                    NotificationScreen()
                }
            }
            AppBottomNavigation(
                selectedDestination = selectedDestination,
                navigateTopLevelDestination = navigateTopLevelDestination
            )
        }
    }
}

@Composable
fun AppBottomNavigation(
    selectedDestination: String,
    navigateTopLevelDestination: (AppTopLevelDestination) -> Unit
) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        TOP_LEVEL_DESTINATIONS.forEach { destinations ->
            NavigationBarItem(
                selected = selectedDestination == destinations.route,
                onClick = { navigateTopLevelDestination(destinations) },
                icon = {
                    Icon(
                        imageVector = destinations.selectedIcon,
                        contentDescription = stringResource(id = destinations.iconTextId)
                    )
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NextYellowBusAppTheme {
        val navController = rememberNavController()
        val navigateAction = remember(navController) {
            AppNavigationActions(navController)
        }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val selectedDestination = navBackStackEntry?.destination?.route ?: AppRoute.NOTIFICATION
        AppContent(
            navController = navController,
            selectedDestination = selectedDestination,
            navigateTopLevelDestination = navigateAction::navigateTo
        )
    }
}