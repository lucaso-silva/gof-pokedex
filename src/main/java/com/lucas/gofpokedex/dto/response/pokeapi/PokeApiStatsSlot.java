package com.lucas.gofpokedex.dto.response.pokeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokeApiStatsSlot(@JsonProperty("base_stat") Integer baseStat,
                               PokeApiStat stat) {
}
