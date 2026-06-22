package com.lucas.gofpokedex.mapper;

import com.lucas.gofpokedex.dto.response.pokeapi.PokeApiPokemonResponse;
import com.lucas.gofpokedex.dto.response.pokeapi.PokeApiStatsSlot;
import com.lucas.gofpokedex.entity.Pokemon;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PokemonMapper {

    public Pokemon pokeApiResponseToPokemon(PokeApiPokemonResponse response) {
        var types = response.types().stream()
                .map(slot -> slot.type().name())
                .toList();
        var abilities = response.abilities().stream()
                .map(slot -> slot.ability().name())
                .toList();

        return Pokemon.builder()
                .id(response.id())
                .name(response.name())
                .height(response.height())
                .weight(response.weight())
                .types(types)
                .abilities(abilities)
                .attack(extractStat(response.stats(), "attack"))
                .defense(extractStat(response.stats(), "defense"))
                .speed(extractStat(response.stats(), "speed"))
                .baseXP(response.baseXP())
                .build();
    }

    private int extractStat(List<PokeApiStatsSlot> stats, String statName){
        return stats.stream()
                .filter(slot -> slot.stat().name().equalsIgnoreCase(statName))
                .findFirst()
                .map(PokeApiStatsSlot::baseStat)
                .orElse(0);
    }
}
