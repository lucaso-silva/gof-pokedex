package com.lucas.gofpokedex.service.impl;

import com.lucas.gofpokedex.dto.response.PokemonListOutput;
import com.lucas.gofpokedex.repository.PokemonRepository;
import com.lucas.gofpokedex.service.ListPokemons;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ListPokemonsImpl implements ListPokemons {
    private final PokemonRepository pokemonRepository;

    @Override
    public List<PokemonListOutput> listAll() {
        return pokemonRepository.findAll().stream()
                .map(PokemonListOutput::from)
                .toList();
    }
}
