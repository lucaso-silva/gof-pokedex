package com.lucas.gofpokedex.dto.response;

import com.lucas.gofpokedex.entity.Pokemon;

public record SavePokemonOutput(Long id,
                                String name,
                                String type,
                                int baseXp) {
    public static SavePokemonOutput from(Pokemon pokemon) {
        return new SavePokemonOutput(pokemon.getId(),
                pokemon.getName(),
                String.join(", ", pokemon.getTypes()),
                pokemon.getBaseXP());
    }
}
