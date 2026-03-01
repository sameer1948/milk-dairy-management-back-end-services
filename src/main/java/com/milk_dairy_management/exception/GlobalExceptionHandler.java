package com.milk_dairy_management.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

import static com.milk_dairy_management.constants.Constants.FAILED;
import static com.milk_dairy_management.constants.Constants.MESSAGE;
import static com.milk_dairy_management.constants.Constants.STATUS;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handle DataIntegrityViolationException, which is thrown when a database constraint is violated,
     * such as a unique constraint violation (e.g., duplicate Phone, email ...,etc.).
     *
     * @param exception the exception that was thrown
     * @return a map containing the error message and status
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleDuplicate(DataIntegrityViolationException exception) {

        Map<String, String> error = new HashMap<>();
        if (exception.getRootCause() != null) {
            error.put(MESSAGE, exception.getRootCause().getMessage());
        } else {
            error.put(MESSAGE, exception.getMessage());
        }
        error.put(STATUS, FAILED);

        return error;
    }
}