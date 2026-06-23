package com.lucas.gofpokedex.service.impl;

import com.lucas.gofpokedex.dto.response.PokemonOutput;
import com.lucas.gofpokedex.exception.PokemonNotFoundException;
import com.lucas.gofpokedex.repository.PokemonRepository;
import com.lucas.gofpokedex.service.GetPokemonByName;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class GetPokemonByNameImpl implements GetPokemonByName {
    private final PokemonRepository pokemonRepository;

    @Override
    public PokemonOutput getByName(String name) {
        var pokemon = pokemonRepository.findByName(name)
                .orElseThrow(() -> new PokemonNotFoundException(name));

        return PokemonOutput.from(pokemon);
    }
}
