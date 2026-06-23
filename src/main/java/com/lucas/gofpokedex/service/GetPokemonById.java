package com.lucas.gofpokedex.service;

import com.lucas.gofpokedex.dto.response.PokemonOutput;

public interface GetPokemonById {
    PokemonOutput getById(Long id);
}
