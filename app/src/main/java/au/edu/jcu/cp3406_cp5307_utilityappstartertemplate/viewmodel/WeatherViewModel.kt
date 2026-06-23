package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.OutfitRules
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherUiState
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepository()

    private val _uiState = MutableStateFlow(
        WeatherUiState(isLoading = true)
    )

    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    init {
        loadWeather()
    }

    private fun loadWeather() {
        viewModelScope.launch {
            try {
                _uiState.value = WeatherUiState(isLoading = true)

                val weather = repository.getWeather()

                _uiState.value = WeatherUiState(
                    isLoading = false,
                    weather = weather,
                    outfitRecommendation = OutfitRules.getRecommendation(
                        temperature = weather.temperature,
                        rainChance = weather.rainChance
                    )
                )
            } catch (e: Exception) {
                _uiState.value = WeatherUiState(
                    isLoading = false,
                    errorMessage = e.message ?: "Unable to load weather data"
                )
            }
        }
    }
}