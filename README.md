# WeatherFit - CP3406 Assessment 1 Utility App

## Overview

WeatherFit is a utility-style Android application developed for CP3406 Assessment 1.

The application provides quick, at-a-glance weather information and personalised outfit recommendations based on current weather conditions. The goal is to help users make simple daily clothing decisions without needing to browse detailed weather forecasts.

The app is built using Kotlin, Jetpack Compose, Material Design 3, ViewModel architecture, Repository pattern, and Retrofit for API communication.

---

## Purpose

Many weather applications provide large amounts of information that can be overwhelming when users simply want to know:

* What is the weather right now?
* What should I wear?
* Do I need an umbrella?

WeatherFit focuses only on the most relevant information and presents it in a clean and easy-to-read format.

---

## Planned Features

### Utility Screen

The main screen will display:

* Current location
* Current temperature
* Weather condition
* Feels-like temperature
* Chance of rain
* Outfit recommendation
* Umbrella recommendation

Example:

Temperature: 29°C

Condition: Partly Cloudy

Recommendation:

* Light T-shirt
* Shorts
* Carry an umbrella

---

### Settings Screen

The settings screen allows users to customise app behaviour.

Planned settings include:

* Temperature Unit

    * Celsius
    * Fahrenheit

* Outfit Style

    * Casual
    * Smart Casual

* Rain Alert Preference

    * Enabled
    * Disabled

Settings are not required to persist between sessions.

---

## Technical Architecture

### User Interface

* Jetpack Compose
* Material Design 3
* Scaffold Layout
* Bottom Navigation

### State Management

* ViewModel

### Data Layer

* Repository Pattern

### Networking

* Retrofit
* Weather API

### Dependency Management

* Dependency Injection

---

## Project Structure

MainActivity.kt

Application entry point.

UtilityScreen()

Displays weather information and outfit recommendations.

SettingsScreen()

Displays user configuration options.

ViewModel

Manages UI state and business logic.

Repository

Handles data retrieval and processing.

Retrofit Service

Retrieves weather data from an external API.

---

## Development Progress

### Completed

* Android Studio environment setup
* Emulator configuration
* GitHub repository setup
* Starter template verification
* Initial project architecture review

### In Progress

* Weather utility design
* UI planning
* Repository implementation

### Planned

* ViewModel integration
* Retrofit API integration
* Outfit recommendation logic
* Error handling
* UI refinement
* Testing

---

## Technologies

* Kotlin
* Android Studio
* Jetpack Compose
* Material Design 3
* ViewModel
* Repository Pattern
* Retrofit
* Git
* GitHub

---

## GitHub Repository

Version control is managed through GitHub with regular commits documenting development progress throughout the project lifecycle.

---

## Author

Yuvraj Dave

CP3406 Assessment 1

James Cook University Singapore
