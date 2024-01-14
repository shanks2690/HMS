package org.hms.doctormicroservice.exception;

import org.hms.doctormicroservice.exception.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleUserNotFoundException(UserNotFoundException ex) {

        ApiResponse response = ApiResponse.builder().message(ex.getMessage()).status(HttpStatus.NOT_FOUND).success(true).build();
return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ApiResponse> handleErrorSavingUserException(ErrorSavingUserException ex) {

        ApiResponse response = ApiResponse.builder().message(ex.getMessage()).status(HttpStatus.BAD_REQUEST).success(true).build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
    }
}
