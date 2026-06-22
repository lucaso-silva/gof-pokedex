package com.lucas.gofpokedex.service.impl;

import com.lucas.gofpokedex.dto.response.SavePokemonOutput;
import com.lucas.gofpokedex.exception.PokemonAlreadyCaughtException;
import com.lucas.gofpokedex.mapper.PokemonMapper;
import com.lucas.gofpokedex.repository.PokemonRepository;
import com.lucas.gofpokedex.service.PokeApiService;
import com.lucas.gofpokedex.service.SavePokemon;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class SavePokemonImpl implements SavePokemon {

    private final PokeApiService pokeApiService;
    private final PokemonRepository pokemonRepository;
    private final PokemonMapper mapper;

    @Override
    public SavePokemonOutput save(String name) {

        if(pokemonRepository.existsByName(name)){
            throw new PokemonAlreadyCaughtException("You already caught a %s".formatted(name));
        }

        var response = pokeApiService.getPokemonByName(name);
        var newPokemon = mapper.pokeApiResponseToPokemon(response);

        return SavePokemonOutput.from(pokemonRepository.save(newPokemon));
    }
}
