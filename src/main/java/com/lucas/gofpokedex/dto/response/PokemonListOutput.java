package com.lucas.gofpokedex.dto.response;

import com.lucas.gofpokedex.entity.Pokemon;

public record PokemonListOutput(Long id,
                                String name,
                                String type) {
    public static PokemonListOutput from(Pokemon pokemon) {
        return new PokemonListOutput(pokemon.getId(),
                pokemon.getName(),
                String.join(", ",  pokemon.getTypes()));
    }
}
