package ru.untitled.skolkovo.exception;

public class DataFormatException extends Exception {
    private String fieldValue;

    public String getFieldValue() {
        return fieldValue;
    }

    public DataFormatException(String message, String value) {
        super(message);
        fieldValue = value;
    }
}
