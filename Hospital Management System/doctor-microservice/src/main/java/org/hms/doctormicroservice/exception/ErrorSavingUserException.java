package org.hms.doctormicroservice.exception;

public class ErrorSavingUserException extends  RuntimeException{
    public ErrorSavingUserException(String message) {
        super(message);
    }

    public ErrorSavingUserException() {
        super("Internal Error");
    }
}
