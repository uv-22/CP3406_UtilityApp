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
import androidx.compose.ui.graphics.Color

@Composable
fun WeatherCard(
    weather: WeatherData,
    useFahrenheit: Boolean,
    modifier: Modifier = Modifier
) {
    val contentColor = MaterialTheme.colorScheme.onPrimaryContainer
    val cardColor = weatherCardColor(weather.condition)

    val temperature = formatTemperature(
        celsius = weather.temperature,
        useFahrenheit = useFahrenheit
    )

    val feelsLike = formatTemperature(
        celsius = weather.feelsLike,
        useFahrenheit = useFahrenheit
    )

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(28.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.cardColors(
            containerColor = cardColor,
            contentColor = contentColor
        )
    ) {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
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

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = temperature,
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

            HorizontalDivider(
                color = contentColor.copy(alpha = 0.15f)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                WeatherDetailRow(
                    icon = Icons.Default.Thermostat,
                    label = "Feels like",
                    value = feelsLike,
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
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                    modifier = Modifier.size(18.dp)
                )

                Spacer(
                    modifier = Modifier.width(6.dp)
                )

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

private fun weatherIconFor(condition: String): ImageVector {
    val lowerCondition = condition.lowercase()

    return when {
        "thunder" in lowerCondition || "storm" in lowerCondition -> Icons.Default.Thunderstorm
        "rain" in lowerCondition || "drizzle" in lowerCondition || "shower" in lowerCondition -> Icons.Default.WaterDrop
        "snow" in lowerCondition || "sleet" in lowerCondition -> Icons.Default.AcUnit
        "cloud" in lowerCondition || "overcast" in lowerCondition || "fog" in lowerCondition || "mist" in lowerCondition -> Icons.Default.Cloud
        else -> Icons.Default.WbSunny
    }
}

private fun formatTemperature(
    celsius: Double,
    useFahrenheit: Boolean
): String {
    return if (useFahrenheit) {
        val fahrenheit = celsius * 9 / 5 + 32
        "${fahrenheit.roundToInt()}°F"
    } else {
        "${celsius.roundToInt()}°C"
    }
}
private fun weatherCardColor(condition: String): Color {
    val c = condition.lowercase()

    return when {
        "clear" in c || "sun" in c -> Color(0xFFFFCC80)
        "cloud" in c -> Color(0xFFB0BEC5)
        "rain" in c || "drizzle" in c -> Color(0xFF81D4FA)
        "storm" in c || "thunder" in c -> Color(0xFF7986CB)
        "snow" in c -> Color(0xFFE1F5FE)
        else -> Color(0xFFE3F2FD)
    }
}