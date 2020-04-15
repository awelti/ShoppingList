package com.tim19.weblab.error;

public class CartitemNotFoundException extends RuntimeException {

    public CartitemNotFoundException(String message) {
        super(message);
    }
}
