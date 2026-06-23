package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model

data class WeatherUiState(
    val isLoading: Boolean = false,
    val weather: WeatherData? = null,
    val errorMessage: String? = null
)