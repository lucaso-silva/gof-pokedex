package com.lucas.gofpokedex.service.impl;

import com.lucas.gofpokedex.dto.response.PokemonOutput;
import com.lucas.gofpokedex.exception.PokemonNotFoundException;
import com.lucas.gofpokedex.repository.PokemonRepository;
import com.lucas.gofpokedex.service.GetPokemonById;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class GetPokemonByIdImpl implements GetPokemonById {
    private final PokemonRepository pokemonRepository;

    @Override
    public PokemonOutput getById(Long id) {
        var pokemon = pokemonRepository.findById(id)
                .orElseThrow(()-> new PokemonNotFoundException("There is no Pokémon with id %s".formatted(id)));

        return PokemonOutput.from(pokemon);
    }
}
