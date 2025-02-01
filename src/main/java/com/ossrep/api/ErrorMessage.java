package com.ossrep.api;

public record ErrorMessage(
        String path,
        String message) {

    public ErrorMessage(String message) {
        this(null, message);
    }

}
