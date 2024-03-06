package com.main.nextyellowbusapp.core


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.main.nextyellowbusapp.R

class AppNavigationActions(private val navController: NavHostController) {
    fun navigateTo(destination: AppTopLevelDestination) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

data class AppTopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val iconTextId: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    AppTopLevelDestination(
        route = AppRoute.TRAVEL,
        selectedIcon = Icons.Default.Send,
        iconTextId = R.string.travel
    ),
    AppTopLevelDestination(
        route = AppRoute.TICKET,
        selectedIcon = Icons.Default.Star,
        iconTextId = R.string.ticket
    ),
    AppTopLevelDestination(
        route = AppRoute.NOTIFICATION,
        selectedIcon = Icons.Default.Notifications,
        iconTextId = R.string.notification
    ),
)

object AppRoute {
    const val TRAVEL = "travel"
    const val TICKET = "ticket"
    const val NOTIFICATION = "notification"
}