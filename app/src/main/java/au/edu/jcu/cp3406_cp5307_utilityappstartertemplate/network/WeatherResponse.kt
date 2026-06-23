package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network

data class WeatherResponse(
    val current: CurrentWeather,
    val hourly: HourlyWeather
)

data class CurrentWeather(
    val temperature_2m: Double,
    val apparent_temperature: Double,
    val weather_code: Int
)

data class HourlyWeather(
    val precipitation_probability: List<Int>
)