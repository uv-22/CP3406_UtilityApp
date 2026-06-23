package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network

data class WeatherResponse(
    val current: CurrentWeather
)

data class CurrentWeather(
    val temperature_2m: Double,
    val apparent_temperature: Double
)