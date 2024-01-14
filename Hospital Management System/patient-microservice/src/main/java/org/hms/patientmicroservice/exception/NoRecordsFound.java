package org.hms.patientmicroservice.exception;

public class NoRecordsFound extends  RuntimeException{
    public NoRecordsFound(String message) {
        super(message);
    }

    public NoRecordsFound() {
        super("Internal Error");
    }
}
