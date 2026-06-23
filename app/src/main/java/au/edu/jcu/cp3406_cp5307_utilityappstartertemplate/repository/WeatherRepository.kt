package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.repository

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherData

class WeatherRepository {

    fun getWeather(): WeatherData {
        return WeatherData(
            location = "Singapore",
            temperature = 29.0,
            feelsLike = 33.0,
            condition = "Partly Cloudy",
            rainChance = 70
        )
    }
}