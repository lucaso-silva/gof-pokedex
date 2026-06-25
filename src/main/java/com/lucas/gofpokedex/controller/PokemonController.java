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
@RequestMapping("/api/pokemons")
@AllArgsConstructor
public class PokemonController {

    private SavePokemon savePokemon;
    private ListPokemons listPokemons;
    private GetPokemonByName getPokemonByName;
    private GetPokemonById getPokemonById;

    @PostMapping
    public ResponseEntity<SavePokemonOutput> save(@RequestBody PokemonRequest pokemon){
        return ResponseEntity.ok(savePokemon.save(pokemon.name()));
    }

    @GetMapping
    public ResponseEntity<List<PokemonListOutput>> listAll(){
        return ResponseEntity.ok(listPokemons.listAll());
    }

    @GetMapping(params = "name")
    public ResponseEntity<PokemonOutput> findByName(@RequestParam String name){
        return ResponseEntity.ok(getPokemonByName.getByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PokemonOutput> findById(@PathVariable Long id){
        return ResponseEntity.ok(getPokemonById.getById(id));
    }
}
