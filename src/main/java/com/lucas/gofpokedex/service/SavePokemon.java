package com.lucas.gofpokedex.service;

import com.lucas.gofpokedex.dto.response.SavePokemonOutput;

public interface SavePokemon {
    SavePokemonOutput save(String name);
}
