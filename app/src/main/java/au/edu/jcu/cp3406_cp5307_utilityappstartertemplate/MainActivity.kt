package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.components.OutfitRecommendationCard
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.components.WeatherCard
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.ui.theme.CP3406_CP5603UtilityAppStarterTemplateTheme
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel.SettingsViewModel
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
fun UtilityApp(
    weatherViewModel: WeatherViewModel = viewModel(),
    settingsViewModel: SettingsViewModel = viewModel()
) {
    var selectedTab by remember { mutableStateOf("Utility") }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Utility"
                        )
                    },
                    label = { Text("Utility") },
                    selected = selectedTab == "Utility",
                    onClick = { selectedTab = "Utility" }
                )

                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    },
                    label = { Text("Settings") },
                    selected = selectedTab == "Settings",
                    onClick = { selectedTab = "Settings" }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            when (selectedTab) {
                "Utility" -> UtilityScreen(
                    weatherViewModel = weatherViewModel,
                    settingsViewModel = settingsViewModel
                )

                "Settings" -> SettingsScreen(
                    settingsViewModel = settingsViewModel
                )
            }
        }
    }
}

@Composable
fun UtilityScreen(
    weatherViewModel: WeatherViewModel,
    settingsViewModel: SettingsViewModel
) {
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

        if (weather != null) {
            WeatherCard(
                weather = weather,
                useFahrenheit = settingsViewModel.useFahrenheit
            )

            if (recommendation != null) {
                OutfitRecommendationCard(
                    recommendation = recommendation
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
fun SettingsScreen(settingsViewModel: SettingsViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.headlineMedium
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Use Fahrenheit",
                style = MaterialTheme.typography.bodyLarge
            )

            Switch(
                checked = settingsViewModel.useFahrenheit,
                onCheckedChange = { isChecked ->
                    settingsViewModel.toggleTemperatureUnit(isChecked)
                }
            )
        }
    }
}