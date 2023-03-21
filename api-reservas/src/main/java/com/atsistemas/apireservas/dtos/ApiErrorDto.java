package com.atsistemas.apireservas.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiErrorDto {
    private HttpStatus status;
    private String path;
    private String error;
    private String message;
    private Instant instant;
}
