package com.test.ecommerce.exception;

public class CartException extends RuntimeException {

    public CartException(String mensagem) {
        super(mensagem);
    }
}