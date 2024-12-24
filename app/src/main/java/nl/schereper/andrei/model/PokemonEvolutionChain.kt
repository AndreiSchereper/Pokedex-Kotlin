package nl.schereper.andrei.model
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PokemonEvolutionChain(
    val chain: ChainLink // Starting point of the evolution chain
) {
    val evolutionChainList: List<PokemonEvolution>
        get() {
            val result = mutableListOf<PokemonEvolution>()
            var current = chain

            while (current.species != null) {
                current.species?.let { species ->
                    result.add(
                        PokemonEvolution(
                            name = species.name,
                            id = species.id,
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${species.id}.png"
                        )
                    )
                }
                if (current.evolvesTo.isEmpty()) break
                current = current.evolvesTo[0]
            }
            return result
        }

    @JsonClass(generateAdapter = true)
    data class ChainLink(
        val species: Species?,        // Pokémon species details
        @Json(name = "evolves_to")
        val evolvesTo: List<ChainLink> // Possible evolutions
    )

    @JsonClass(generateAdapter = true)
    data class Species(
        val name: String, // Pokémon species name
        val url: String   // URL containing detailed information
    ) {
        val id: Int
            get() = url.split("/").lastOrNull()?.toIntOrNull() ?: 0
    }
}

data class PokemonEvolution(
    val name: String,  // Pokémon name
    val id: Int,       // Pokémon ID
    val imageUrl: String // Sprite image URL
)