package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data

class PreferencesRepository {

    private var preferences = UserPreferences()

    fun getPreferences(): UserPreferences {
        return preferences
    }

    fun updateUseFahrenheit(enabled: Boolean) {
        preferences = preferences.copy(
            useFahrenheit = enabled
        )
    }
}