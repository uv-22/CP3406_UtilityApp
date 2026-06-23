package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.OutfitRecommendation

data class WeatherUiState(
    val isLoading: Boolean = false,
    val outfitRecommendation: OutfitRecommendation? = null,
    val weather: WeatherData? = null,
    val errorMessage: String? = null
)