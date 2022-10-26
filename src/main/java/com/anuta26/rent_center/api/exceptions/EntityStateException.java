package com.anuta26.rent_center.api.exceptions;

public class EntityStateException extends RuntimeException {
    public EntityStateException() {
        super("Illegal state of entity");
    }

    public <E> EntityStateException(E entity) {
        super("Illegal state of entity " + entity);
    }
}
