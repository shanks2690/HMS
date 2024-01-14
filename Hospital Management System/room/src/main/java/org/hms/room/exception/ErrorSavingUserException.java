package org.hms.room.exception;

public class ErrorSavingUserException extends  RuntimeException{
    public ErrorSavingUserException(String message) {
        super(message);
    }

    public ErrorSavingUserException() {
        super("Internal Error");
    }
}
