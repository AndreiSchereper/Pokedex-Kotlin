package nl.schereper.andrei.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonDetails(
    val id: Int,                   // Pokémon ID
    val name: String,              // Pokémon name
    @Json(name = "base_experience")
    val baseExperience: Int,       // Base experience points
    val height: Int,               // Height in decimeters
    val weight: Int,               // Weight in hectograms
    val sprites: Sprites,          // Sprite URLs
    val types: List<PokemonType>,  // Types associated with the Pokémon
    val abilities: List<Ability>,  // Abilities the Pokémon can have
    val stats: List<Stat>          // Stats of the Pokémon
) {
    @JsonClass(generateAdapter = true)
    data class Sprites(
        @Json(name = "front_default")
        val frontDefault: String?, // Front-facing image URL
        @Json(name = "back_default")
        val backDefault: String?   // Back-facing image URL
    )

    @JsonClass(generateAdapter = true)
    data class PokemonType(
        val type: TypeName // Type information
    ) {
        @JsonClass(generateAdapter = true)
        data class TypeName(
            val name: String // Name of the type (e.g., "fire", "water")
        )
    }

    @JsonClass(generateAdapter = true)
    data class Ability(
        val ability: AbilityName // Ability information
    ) {
        @JsonClass(generateAdapter = true)
        data class AbilityName(
            val name: String // Name of the ability (e.g., "Overgrow")
        )
    }

    @JsonClass(generateAdapter = true)
    data class Stat(
        @Json(name = "base_stat")
        val baseStat: Int,   // Base stat value
        val stat: StatName   // Stat information
    ) {
        @JsonClass(generateAdapter = true)
        data class StatName(
            val name: String // Name of the stat (e.g., "speed", "attack")
        )
    }
}