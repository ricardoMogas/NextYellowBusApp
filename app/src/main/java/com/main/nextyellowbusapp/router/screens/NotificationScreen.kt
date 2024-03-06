package com.main.nextyellowbusapp.router.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun NotificationScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       item {
           Text(text = "Notifications")
           Spacer(modifier = Modifier.width(8.dp))
       }
        items(notifications.size) { index ->
            NotificationCard(notification = notifications[index])
        }
    }
}

@Composable
fun NotificationCard(notification: Notification) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(notification.icon, contentDescription = "Notification Icon")
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(text = notification.title, style = MaterialTheme.typography.bodyLarge)
                Text(text = notification.description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}

data class Notification(
    val icon: ImageVector,
    val title: String,
    val description: String
)

val notifications = listOf(
    Notification(Icons.Default.Notifications, "Viaje Villa Hermosa proto a salir", "su viaje esta por salir aproximadamente en 20 minutos por favor estar en la parada 5 minutos antes"),
    Notification(Icons.Default.Warning, "Viaje Villa Hermosa Retraso", "Su Viaje Se retraso 10 minutos disculpe las molestias"),
    Notification(Icons.Default.Warning, "Viaje Villa Hermosa Retraso", "Su Viaje Se retraso 10 minutos disculpe las molestias"),
    Notification(Icons.Default.Warning, "Viaje Villa Hermosa Retraso", "Su Viaje Se retraso 10 minutos disculpe las molestias"),
    Notification(Icons.Default.Warning, "Viaje Villa Hermosa Retraso", "Su Viaje Se retraso 10 minutos disculpe las molestias"),
    Notification(Icons.Default.Warning, "Viaje Villa Hermosa Retraso", "Su Viaje Se retraso 10 minutos disculpe las molestias"),
    Notification(Icons.Default.Notifications, "Viaje Villa Hermosa proto a salir", "su viaje esta por salir aproximadamente en 20 minutos por favor estar en la parada 5 minutos antes"),
    Notification(Icons.Default.Notifications, "Viaje Villa Hermosa proto a salir", "su viaje esta por salir aproximadamente en 20 minutos por favor estar en la parada 5 minutos antes"),
    Notification(Icons.Default.Notifications, "Viaje Villa Hermosa proto a salir", "su viaje esta por salir aproximadamente en 20 minutos por favor estar en la parada 5 minutos antes"),
    Notification(Icons.Default.Notifications, "Viaje Villa Hermosa proto a salir", "su viaje esta por salir aproximadamente en 20 minutos por favor estar en la parada 5 minutos antes"),
    Notification(Icons.Default.Notifications, "Viaje Villa Hermosa proto a salir", "su viaje esta por salir aproximadamente en 20 minutos por favor estar en la parada 5 minutos antes"),
    Notification(Icons.Default.Notifications, "Viaje Villa Hermosa proto a salir", "su viaje esta por salir aproximadamente en 20 minutos por favor estar en la parada 5 minutos antes"),
    // Agrega más notificaciones aquí
)