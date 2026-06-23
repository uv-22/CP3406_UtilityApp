package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.repository

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherData
import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.network.RetrofitClient

class WeatherRepository {

    suspend fun getWeather(): WeatherData {

        val response = RetrofitClient.api.getWeather(
            latitude = 1.3521,
            longitude = 103.8198
        )

        return WeatherData(
            location = "Singapore",
            temperature = response.current.temperature_2m,
            feelsLike = response.current.apparent_temperature,
            condition = "Current Weather",
            rainChance = 0
        )
    }
}