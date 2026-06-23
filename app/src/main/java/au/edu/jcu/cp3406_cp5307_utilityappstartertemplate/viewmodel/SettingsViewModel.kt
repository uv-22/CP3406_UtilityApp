package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.PreferencesRepository
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.PresetLocations
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherLocation

class SettingsViewModel : ViewModel() {

    private val repository = PreferencesRepository()

    var useFahrenheit by mutableStateOf(
        repository.getPreferences().useFahrenheit
    )
        private set
    var selectedLocation by mutableStateOf(
        PresetLocations.defaultLocation
    )
        private set

    fun updateLocation(location: WeatherLocation) {
        selectedLocation = location
    }
    fun toggleTemperatureUnit(enabled: Boolean) {
        repository.updateUseFahrenheit(enabled)
        useFahrenheit = repository.getPreferences().useFahrenheit
    }
}