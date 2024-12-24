package nl.schereper.andrei.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonSpecies(
    @Json(name = "evolution_chain")
    val evolutionChain: EvolutionChain // Evolution chain details
) {
    @JsonClass(generateAdapter = true)
    data class EvolutionChain(
        val url: String // URL for the evolution chain data
    )
}