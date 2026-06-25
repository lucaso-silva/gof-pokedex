package com.lucas.gofpokedex.exception;

public class PokemonAlreadyCaughtException extends BusinessException {
    private static final String CODE = "pokemon.duplicated-item";
    private static final Integer HTTP_STATUS = 409;

    public PokemonAlreadyCaughtException(String message) {
        super(CODE, message, HTTP_STATUS);
    }
}
