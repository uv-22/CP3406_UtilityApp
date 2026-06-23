# WeatherFit - CP3406 Assessment 1 Utility App

## Overview

WeatherFit is an Android utility application developed for CP3406 Assessment 1 at James Cook University Singapore.

The application provides real-time weather information and personalised outfit recommendations to help users quickly decide what to wear based on current weather conditions. Unlike traditional weather applications that present large amounts of forecast data, WeatherFit focuses on delivering concise and practical information in a clean and easy-to-use interface.

The application is built using Kotlin, Jetpack Compose, Material Design 3, ViewModel architecture, the Repository pattern, and Retrofit networking.

---

## Features

### Weather Information

The application displays:

* Current location
* Current temperature
* Feels-like temperature
* Weather condition
* Chance of rain

Weather data is retrieved from an online weather service using Retrofit.

---

### Outfit Recommendations

WeatherFit analyses current weather conditions and provides:

* Clothing recommendations
* Weather advice
* Accessory recommendations

Examples include:

* Carrying an umbrella during rainy conditions
* Wearing lightweight clothing during hot weather
* Wearing additional layers during cooler conditions

---

### Settings

The settings screen allows users to customise the application.

Current settings include:

* Temperature Unit

  * Celsius
  * Fahrenheit

* Weather Location

  * Singapore
  * Tokyo
  * London
  * New York
  * Sydney

Weather data updates dynamically when a different location is selected.

---

## User Interface

The application uses Material Design 3 components and Jetpack Compose.

Main interface elements include:

### Utility Screen

* Weather information card
* Outfit recommendation card
* Loading indicator
* Responsive Compose layout

### Settings Screen

* Temperature settings card
* Location settings card
* Dropdown location selector

---

## Technical Architecture

### User Interface

* Jetpack Compose
* Material Design 3
* Scaffold Layout
* Bottom Navigation

### State Management

* ViewModel
* StateFlow
* Compose State

### Data Layer

* Repository Pattern

### Networking

* Retrofit
* Open-Meteo Weather API

### Architecture Pattern

The project follows a simplified MVVM architecture:

* View (Compose UI)
* ViewModel
* Repository
* API Service

---

## Project Structure

### MainActivity.kt

Application entry point and navigation management.

### WeatherViewModel.kt

Manages weather state, loading states, and outfit recommendation generation.

### SettingsViewModel.kt

Manages application settings and user preferences.

### WeatherRepository.kt

Retrieves and processes weather data.

### WeatherApiService.kt

Defines API endpoints for weather retrieval.

### Components

Reusable UI components:

* WeatherCard
* OutfitRecommendationCard
* SettingsCard

### Models

Application data models including:

* WeatherData
* WeatherUiState
* OutfitRecommendation
* WeatherLocation

---

## Technologies Used

* Kotlin
* Android Studio
* Jetpack Compose
* Material Design 3
* ViewModel
* StateFlow
* Repository Pattern
* Retrofit
* Git
* GitHub

---

## How to Run

1. Clone the repository.
2. Open the project in Android Studio.
3. Sync Gradle dependencies.
4. Start an Android Emulator or connect a physical device.
5. Run the application.

---

## Future Improvements

Potential future enhancements include:

* Persistent settings using DataStore
* Additional weather locations
* Dark mode customisation
* Extended weather forecasts
* GPS-based location detection

---

## Author

Yuvraj Dave

CP3406 Assessment 1

James Cook University Singapore
