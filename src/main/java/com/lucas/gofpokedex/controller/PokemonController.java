package com.lucas.gofpokedex.controller;

import com.lucas.gofpokedex.dto.request.PokemonRequest;
import com.lucas.gofpokedex.dto.response.PokemonListOutput;
import com.lucas.gofpokedex.dto.response.PokemonOutput;
import com.lucas.gofpokedex.dto.response.SavePokemonOutput;
import com.lucas.gofpokedex.service.GetPokemonById;
import com.lucas.gofpokedex.service.GetPokemonByName;
import com.lucas.gofpokedex.service.ListPokemons;
import com.lucas.gofpokedex.service.SavePokemon;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PokemonController implements PokemonApi {

    private final SavePokemon savePokemon;
    private final ListPokemons listPokemons;
    private final GetPokemonByName getPokemonByName;
    private final GetPokemonById getPokemonById;

    @Override
    public ResponseEntity<SavePokemonOutput> save(PokemonRequest pokemon) {
        return ResponseEntity.ok(savePokemon.save(pokemon.name()));
    }

    @Override
    public ResponseEntity<List<PokemonListOutput>> listAll() {
        return ResponseEntity.ok(listPokemons.listAll());
    }

    @Override
    public ResponseEntity<PokemonOutput> findByName(String name) {
        return ResponseEntity.ok(getPokemonByName.getByName(name));
    }

    @Override
    public ResponseEntity<PokemonOutput> findById(Long id) {
        return ResponseEntity.ok(getPokemonById.getById(id));
    }
}