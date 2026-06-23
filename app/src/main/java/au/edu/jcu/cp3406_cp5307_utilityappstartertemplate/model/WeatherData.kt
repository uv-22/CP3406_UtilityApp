package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model

data class WeatherData(
    val location: String,
    val temperature: Double,
    val feelsLike: Double,
    val condition: String,
    val rainChance: Int
)