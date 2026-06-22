package com.lucas.gofpokedex.service;

import com.lucas.gofpokedex.dto.response.pokeapi.PokeApiPokemonResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "pokeApi", url = "https://pokeapi.co/api/v2/pokemon")
public interface PokeApiService {

    @GetMapping("/{name}")
    PokeApiPokemonResponse getPokemonByName(@PathVariable String name);
}
