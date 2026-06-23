package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.lifecycle.ViewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherData
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WeatherViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(
        WeatherUiState(
            weather = WeatherData(
                location = "Singapore",
                temperature = 29.0,
                feelsLike = 33.0,
                condition = "Partly Cloudy",
                rainChance = 70
            )
        )
    )

    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()
}