package org.hms.prescriptionservice.exception;

public class NoRecordsFound extends  RuntimeException{
    public NoRecordsFound(String message) {
        super(message);
    }

    public NoRecordsFound() {
        super("Internal Error");
    }
}
