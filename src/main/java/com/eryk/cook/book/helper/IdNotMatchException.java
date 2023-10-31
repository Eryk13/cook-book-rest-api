package com.eryk.cook.book.helper;

public class IdNotMatchException extends RuntimeException{
    public IdNotMatchException(String message) {
        super(message);
    }

    public IdNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdNotMatchException(Throwable cause) {
        super(cause);
    }
}
