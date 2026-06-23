package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.WaterDrop
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.ui.theme.CP3406_CP5603UtilityAppStarterTemplateTheme
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CP3406_CP5603UtilityAppStarterTemplateTheme {
                UtilityApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UtilityAppPreview() {
    CP3406_CP5603UtilityAppStarterTemplateTheme {
        UtilityApp()
    }
}

@Composable
fun UtilityApp(weatherViewModel: WeatherViewModel = viewModel()) {
    var selectedTab by remember { mutableStateOf("Utility") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Utility") },
                    label = { Text("Utility") },
                    selected = selectedTab == "Utility",
                    onClick = { selectedTab = "Utility" }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selected = selectedTab == "Settings",
                    onClick = { selectedTab = "Settings" }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTab) {
                "Utility" -> UtilityScreen(weatherViewModel)
                "Settings" -> SettingsScreen()
            }
        }
    }
}

@Composable
fun UtilityScreen(weatherViewModel: WeatherViewModel) {
    val uiState by weatherViewModel.uiState.collectAsState()
    val weather = uiState.weather
    val recommendation = uiState.outfitRecommendation

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "WeatherFit",
            style = MaterialTheme.typography.headlineMedium
        )

        Icon(
            imageVector = Icons.Filled.WaterDrop,
            contentDescription = "Rain",
            tint = Color(0xFF2196F3),
            modifier = Modifier.size(32.dp)
        )

        if (weather != null) {
            Text("Location: ${weather.location}", style = MaterialTheme.typography.bodyLarge)
            Text("Temperature: ${weather.temperature}°C", style = MaterialTheme.typography.bodyLarge)
            Text("Feels like: ${weather.feelsLike}°C", style = MaterialTheme.typography.bodyLarge)
            Text("Condition: ${weather.condition}", style = MaterialTheme.typography.bodyLarge)
            Text("Rain chance: ${weather.rainChance}%", style = MaterialTheme.typography.bodyLarge)

            if (recommendation != null) {
                Text(
                    text = recommendation.title,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    text = recommendation.clothingAdvice,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = recommendation.weatherAdvice,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = recommendation.accessoryAdvice,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        } else if (uiState.isLoading) {
            Text(
                text = "Loading weather...",
                style = MaterialTheme.typography.bodyLarge
            )
        } else {
            Text(
                text = uiState.errorMessage ?: "Unable to load weather",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Settings Screen", style = MaterialTheme.typography.headlineMedium)
        Text("This is where you can add toggles or preferences.")
    }
}