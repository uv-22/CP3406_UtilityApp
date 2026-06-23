package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Cloud
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Thermostat
import androidx.compose.material.icons.filled.Thunderstorm
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherData
import kotlin.math.roundToInt

@Composable
fun WeatherCard(
    weather: WeatherData,
    modifier: Modifier = Modifier
) {
    val contentColor = MaterialTheme.colorScheme.onPrimaryContainer

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = contentColor
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            // Location
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location",
                    tint = contentColor.copy(alpha = 0.9f)
                )
                Text(
                    text = weather.location,
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.SemiBold
                )
            }

            // Temperature + condition
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Text(
                        text = "${weather.temperature.roundToInt()}°C",
                        style = MaterialTheme.typography.displayMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = weather.condition,
                        style = MaterialTheme.typography.titleMedium,
                        color = contentColor.copy(alpha = 0.85f)
                    )
                }

                Icon(
                    imageVector = weatherIconFor(weather.condition),
                    contentDescription = weather.condition,
                    tint = contentColor,
                    modifier = Modifier.size(72.dp)
                )
            }

            HorizontalDivider(color = contentColor.copy(alpha = 0.15f))

            // Stats
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                WeatherDetailRow(
                    icon = Icons.Default.Thermostat,
                    label = "Feels like",
                    value = "${weather.feelsLike.roundToInt()}°C",
                    modifier = Modifier.weight(1f)
                )
                WeatherDetailRow(
                    icon = Icons.Default.WaterDrop,
                    label = "Rain chance",
                    value = "${weather.rainChance}%",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun WeatherDetailRow(
    icon: ImageVector,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(18.dp),
        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.08f),
        contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                    modifier = Modifier.size(18.dp)
                )
                Spacer(Modifier.width(6.dp))
                Text(
                    text = label,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                )
            }
            Text(
                text = value,
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.SemiBold
            )
        }
    }
}

/** Picks an icon based on the weather condition text for a dynamic look. */
private fun weatherIconFor(condition: String): ImageVector {
    val c = condition.lowercase()
    return when {
        "thunder" in c || "storm" in c -> Icons.Default.Thunderstorm
        "rain" in c || "drizzle" in c || "shower" in c -> Icons.Default.WaterDrop
        "snow" in c || "sleet" in c -> Icons.Default.AcUnit
        "cloud" in c || "overcast" in c || "fog" in c || "mist" in c -> Icons.Default.Cloud
        else -> Icons.Default.WbSunny
    }
}