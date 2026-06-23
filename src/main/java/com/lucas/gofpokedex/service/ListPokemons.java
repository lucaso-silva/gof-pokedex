package com.lucas.gofpokedex.service;

import com.lucas.gofpokedex.dto.response.PokemonListOutput;

import java.util.List;

public interface ListPokemons {
    List<PokemonListOutput> listAll();
}
