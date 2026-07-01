package com.lucas.gofpokedex.controller;

import com.lucas.gofpokedex.dto.request.PokemonRequest;
import com.lucas.gofpokedex.dto.response.PokemonListOutput;
import com.lucas.gofpokedex.dto.response.PokemonOutput;
import com.lucas.gofpokedex.dto.response.SavePokemonOutput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Pokémons",
        description = "Operations related to capturing, retrieving, and listing Pokémons.")
@RequestMapping("/api/pokemons")
public interface PokemonApi {
    @Operation(
            summary = "Capture a new Pokémon",
            description = "Captures a new Pokémon based on its name, retrieves its information from the external PokéAPI, and stores it in the local database",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Pokémon name to be captured",
            required = true)
    )
    @PostMapping
    ResponseEntity<SavePokemonOutput> save(@Valid @RequestBody PokemonRequest pokemon);

    @Operation(
            summary = "List saved Pokémon",
            description = "Returns all captured Pokémon"
    )
    @GetMapping
    ResponseEntity<List<PokemonListOutput>> listAll();

    @Operation(
            summary = "Retrieve a Pokemon by name",
            description = "Returns detailed information about a captured Pokémon identified by its unique name"
    )
    @GetMapping("/search")
    ResponseEntity<PokemonOutput> findByName(@Parameter(description = "Pokémon name", required = true)
                                             @RequestParam String name);

    @Operation(
            summary = "Retrieve a Pokemon by ID",
            description = "Returns detailed information about a captured Pokémon identified by its unique Id"
    )
    @GetMapping("/{id}")
    ResponseEntity<PokemonOutput> findById(@PathVariable Long id);
}
