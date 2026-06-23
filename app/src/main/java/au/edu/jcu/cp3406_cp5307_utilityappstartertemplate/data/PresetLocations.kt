package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.WeatherLocation

object PresetLocations {

    val locations = listOf(
        WeatherLocation(
            name = "Singapore",
            latitude = 1.3521,
            longitude = 103.8198
        ),
        WeatherLocation(
            name = "Tokyo",
            latitude = 35.6762,
            longitude = 139.6503
        ),
        WeatherLocation(
            name = "London",
            latitude = 51.5072,
            longitude = -0.1276
        ),
        WeatherLocation(
            name = "New York",
            latitude = 40.7128,
            longitude = -74.0060
        ),
        WeatherLocation(
            name = "Sydney",
            latitude = -33.8688,
            longitude = 151.2093
        )
    )

    val defaultLocation = locations.first()
}