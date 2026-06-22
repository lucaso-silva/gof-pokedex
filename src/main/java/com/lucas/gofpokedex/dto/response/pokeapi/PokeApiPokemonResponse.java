package com.lucas.gofpokedex.dto.response.pokeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokeApiPokemonResponse(Long id,
                                     String name,
                                     int height,
                                     int weight,
                                     List<PokeApiTypesSlot> types,
                                     List<PokeApiAbilitiesSlot> abilities,
                                     List<PokeApiStatsSlot> stats,
                                     @JsonProperty("base_experience") int baseXP){
}