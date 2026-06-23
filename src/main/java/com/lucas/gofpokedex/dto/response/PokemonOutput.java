package com.lucas.gofpokedex.dto.response;

import com.lucas.gofpokedex.entity.Pokemon;

public record PokemonOutput(Long id,
                            String name,
                            int height,
                            int weight,
                            String types,
                            String abilities,
                            int attack,
                            int defense,
                            int speed,
                            int baseXP) {
    public static PokemonOutput from(Pokemon pokemon) {
        return new PokemonOutput(pokemon.getId(),
                pokemon.getName(),
                pokemon.getHeight(),
                pokemon.getWeight(),
                String.join(", ", pokemon.getTypes()),
                String.join(", ", pokemon.getAbilities()),
                pokemon.getAttack(),
                pokemon.getDefense(),
                pokemon.getDefense(),
                pokemon.getBaseXP());
    }
}
