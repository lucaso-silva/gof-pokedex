package com.lucas.gofpokedex.repository;

import com.lucas.gofpokedex.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    boolean existsByName(String name);

    Optional<Pokemon> findByName(String name);
}
