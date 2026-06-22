package com.lucas.gofpokedex.dto.response.pokeapi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record PokeApiAbilitiesSlot(PokeApiAbility ability) {
}
