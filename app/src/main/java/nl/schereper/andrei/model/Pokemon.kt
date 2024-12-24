package nl.schereper.andrei.model
import com.squareup.moshi.JsonClass

/**
 * Model representing an individual Pokémon.
 */
@JsonClass(generateAdapter = true)
data class Pokemon(
    val name: String,             // Name of the Pokémon
    val url: String               // URL containing more details about the Pokémon
) {
    val id: Int
        get() = url.split("/").lastOrNull()?.toIntOrNull() ?: 0

    val imageUrl: String
        get() = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/$id.png"
}