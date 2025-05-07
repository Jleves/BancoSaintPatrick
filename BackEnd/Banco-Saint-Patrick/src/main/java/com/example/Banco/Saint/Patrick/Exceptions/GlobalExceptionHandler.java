package com.example.Banco.Saint.Patrick.Exceptions;

import com.example.Banco.Saint.Patrick.Exceptions.dto.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex,  HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND) ;
    }
    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<ErrorResponse> manejarSaldoInsuficiente(SaldoInsuficienteException ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    // Errores inesperados
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> manejarExcepcionGeneral(Exception ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse(
                LocalDate.now(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Ha ocurrido un error inesperado.",
                request.getRequestURI()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}