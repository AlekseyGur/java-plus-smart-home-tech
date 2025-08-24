package ru.yandex.practicum.system.exception;

public class HttpMethodNotSupportedException extends RuntimeException {
    public HttpMethodNotSupportedException(String message) {
        super(message);
    }
}