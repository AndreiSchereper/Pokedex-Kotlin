package nl.schereper.andrei.model
import com.squareup.moshi.JsonClass

/**
 * Response model for the Pokémon list API.
 */
@JsonClass(generateAdapter = true)
data class PokemonListResponse(
    val count: Int,               // Total number of Pokémon available
    val next: String?,            // URL for the next page of results
    val previous: String?,        // URL for the previous page of results
    val results: List<Pokemon>    // List of Pokémon data
)
