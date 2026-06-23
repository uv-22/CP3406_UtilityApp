package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.repository

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherData
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network.RetrofitClient

class WeatherRepository {

    suspend fun getWeather(
        latitude: Double,
        longitude: Double,
        locationName: String
    ): WeatherData {
        val response = RetrofitClient.api.getWeather(
            latitude = latitude,
            longitude = longitude
        )

        return WeatherData(
            location = locationName,
            temperature = response.current.temperature_2m,
            feelsLike = response.current.apparent_temperature,
            condition = mapWeatherCode(response.current.weather_code),
            rainChance = response.hourly.precipitation_probability.firstOrNull() ?: 0
        )
    }

    private fun mapWeatherCode(code: Int): String {
        return when (code) {
            0 -> "Clear"
            1, 2 -> "Partly Cloudy"
            3 -> "Cloudy"
            45, 48 -> "Foggy"
            51, 53, 55 -> "Drizzle"
            61, 63, 65 -> "Rain"
            71, 73, 75 -> "Snow"
            80, 81, 82 -> "Rain Showers"
            95, 96, 99 -> "Thunderstorm"
            else -> "Unknown"
        }
    }
}