package com.lucas.gofpokedex.exception;

public class PokemonNotFoundException extends BusinessException {
    public PokemonNotFoundException(String message) {
        super(message);
    }
}
