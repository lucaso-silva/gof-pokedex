package com.lucas.gofpokedex.exception;

import org.springframework.http.HttpStatus;

public class PokemonNotFoundException extends BusinessException {
    private static final String CODE = "pokemon.not-found";
    private static final Integer HTTP_STATUS = 404;

    public PokemonNotFoundException(String message) {
        super(CODE, message, HTTP_STATUS);
    }
}
