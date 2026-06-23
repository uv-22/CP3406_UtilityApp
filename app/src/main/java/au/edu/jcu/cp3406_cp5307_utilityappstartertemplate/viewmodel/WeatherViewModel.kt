package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.lifecycle.ViewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherData
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.repository.WeatherRepository

class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepository()

    private val _uiState = MutableStateFlow(
        WeatherUiState(
            weather = repository.getWeather()
        )
    )

    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()
}