package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SettingsViewModel : ViewModel() {

    var useFahrenheit by mutableStateOf(false)
        private set

    fun toggleTemperatureUnit(enabled: Boolean) {
        useFahrenheit = enabled
    }
}