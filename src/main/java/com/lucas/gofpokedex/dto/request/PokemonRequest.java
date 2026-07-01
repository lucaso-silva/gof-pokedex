package com.lucas.gofpokedex.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

public record PokemonRequest(@Schema(description = "Pokemon name", example = "eevee")
                             @NotBlank(message = "Please inform the Pokémon name")
                             String name) {
}
