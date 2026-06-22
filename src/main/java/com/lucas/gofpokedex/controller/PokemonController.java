package com.lucas.gofpokedex.controller;

import com.lucas.gofpokedex.dto.request.PokemonRequest;
import com.lucas.gofpokedex.dto.response.SavePokemonOutput;
import com.lucas.gofpokedex.service.SavePokemon;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemons")
@AllArgsConstructor
public class PokemonController {

    private SavePokemon savePokemon;

    @PostMapping
    public ResponseEntity<SavePokemonOutput> save(@RequestBody PokemonRequest pokemon){

        return ResponseEntity.ok(savePokemon.save(pokemon.name()));
    }

}
