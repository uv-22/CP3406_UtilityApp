package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data.PreferencesRepository

class SettingsViewModel : ViewModel() {

    private val repository = PreferencesRepository()

    var useFahrenheit by mutableStateOf(
        repository.getPreferences().useFahrenheit
    )
        private set

    fun toggleTemperatureUnit(enabled: Boolean) {
        repository.updateUseFahrenheit(enabled)
        useFahrenheit = repository.getPreferences().useFahrenheit
    }
}