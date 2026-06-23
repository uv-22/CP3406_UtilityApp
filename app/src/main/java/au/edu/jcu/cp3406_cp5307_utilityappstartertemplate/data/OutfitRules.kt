package au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.data

import au.edu.jcu.cp3406_cp5307_utilityappstartertemplate.model.OutfitRecommendation

object OutfitRules {

    fun getRecommendation(
        temperature: Double,
        rainChance: Int
    ): OutfitRecommendation {

        return when {

            rainChance >= 60 -> OutfitRecommendation(
                title = "Rainy Weather",
                clothingAdvice = "Light clothing",
                weatherAdvice = "Carry an umbrella",
                accessoryAdvice = "Water-resistant footwear recommended"
            )

            temperature >= 32 -> OutfitRecommendation(
                title = "Hot Weather",
                clothingAdvice = "T-shirt and shorts",
                weatherAdvice = "Stay hydrated",
                accessoryAdvice = "Wear a cap and sunglasses"
            )

            temperature >= 26 -> OutfitRecommendation(
                title = "Warm Weather",
                clothingAdvice = "Light casual clothing",
                weatherAdvice = "Comfortable outdoor conditions",
                accessoryAdvice = "Consider sunglasses"
            )

            temperature >= 20 -> OutfitRecommendation(
                title = "Mild Weather",
                clothingAdvice = "Long sleeves or light jacket",
                weatherAdvice = "Pleasant conditions",
                accessoryAdvice = "No special accessories needed"
            )

            else -> OutfitRecommendation(
                title = "Cool Weather",
                clothingAdvice = "Jacket or sweater",
                weatherAdvice = "Keep warm",
                accessoryAdvice = "Consider an extra layer"
            )
        }
    }
}