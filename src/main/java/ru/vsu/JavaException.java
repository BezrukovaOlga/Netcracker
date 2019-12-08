package ru.vsu;

public class JavaException extends Exception {
    public JavaException(String message) {
        super(message);
    }

    public JavaException(String message, Throwable cause) {
        super(message, cause);
    }
}
