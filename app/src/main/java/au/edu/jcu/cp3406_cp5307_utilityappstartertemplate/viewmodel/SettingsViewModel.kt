package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.PreferencesRepository
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.PresetLocations
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherLocation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SettingsViewModel : ViewModel() {

    private val repository = PreferencesRepository()

    var useFahrenheit by mutableStateOf(
        repository.getPreferences().useFahrenheit
    )
        private set
    private val _selectedLocation =
        MutableStateFlow(PresetLocations.defaultLocation)

    val selectedLocation: StateFlow<WeatherLocation> =
        _selectedLocation.asStateFlow()

    fun updateLocation(location: WeatherLocation) {
        _selectedLocation.value = location
    }
    fun toggleTemperatureUnit(enabled: Boolean) {
        repository.updateUseFahrenheit(enabled)
        useFahrenheit = repository.getPreferences().useFahrenheit
    }
}