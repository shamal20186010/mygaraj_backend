package org.mygaraj.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String massage) {
        super(massage);
    }
}
