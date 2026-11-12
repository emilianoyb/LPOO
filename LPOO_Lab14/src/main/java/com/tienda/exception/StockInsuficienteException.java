package com.tienda.exception;

public class StockInsuficienteException extends RuntimeException {

    public StockInsuficienteException(String titulo) {
        super("No hay existencias de \"" + titulo + "\".");
    }
}
