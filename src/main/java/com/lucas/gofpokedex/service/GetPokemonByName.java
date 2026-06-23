package com.lucas.gofpokedex.service;

import com.lucas.gofpokedex.dto.response.PokemonOutput;

public interface GetPokemonByName {
    PokemonOutput getByName(String name);
}
