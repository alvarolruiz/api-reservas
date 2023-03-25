package com.atsistemas.apireservas.controllers;

import com.atsistemas.apireservas.controllers.Err.InvalidDateFormatException;
import com.atsistemas.apireservas.controllers.Err.NoAvailabilityException;
import com.atsistemas.apireservas.controllers.Err.ResourceNotFoundException;
import com.atsistemas.apireservas.dtos.ApiErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity resourceNotFoundExeptionHandler(ResourceNotFoundException ex, HttpServletRequest request) {
        ApiErrorDto apiErrorDto = new ApiErrorDto(HttpStatus.NOT_FOUND, request.getRequestURL().toString(), ex.getClass().getSimpleName(), ex.getMessage(), Instant.now());
        return new ResponseEntity(apiErrorDto, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NoAvailabilityException.class)
    public ResponseEntity noAvailabilityExceptionHandler(ResourceNotFoundException ex, HttpServletRequest request) {
        ApiErrorDto apiErrorDto = new ApiErrorDto(HttpStatus.NO_CONTENT, request.getRequestURL().toString(), ex.getClass().getSimpleName(), ex.getMessage(), Instant.now());
        return new ResponseEntity(apiErrorDto, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity handleDateTimeParseException(DateTimeParseException ex, HttpServletRequest request) {
        InvalidDateFormatException exception = new InvalidDateFormatException(ex.getParsedString());
        ApiErrorDto apiErrorDto = new ApiErrorDto(HttpStatus.BAD_REQUEST, request.getRequestURL().toString(), ex.getClass().getSimpleName(), exception.getMessage(), Instant.now());
        return new ResponseEntity(apiErrorDto, HttpStatus.BAD_REQUEST);
    }

}
