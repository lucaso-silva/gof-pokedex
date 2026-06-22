package com.lucas.gofpokedex.dto.request;

import jakarta.validation.constraints.NotBlank;

public record PokemonRequest(@NotBlank(message = "Please informe the Pokémon name")
                             String name) {
}
