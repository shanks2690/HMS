package com.shanks.appointmentservice.exception;

public class ErrorSavingRecordException extends  RuntimeException{
    public ErrorSavingRecordException(String message) {
        super(message);
    }

    public ErrorSavingRecordException() {
        super("Internal Error");
    }
}
