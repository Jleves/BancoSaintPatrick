package com.example.Banco.Saint.Patrick.Exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data

@NoArgsConstructor
public class ErrorResponse {
    private LocalDate timestamp;
    private HttpStatus status;
    private String mensaje;
    private String ruta;

    public ErrorResponse(LocalDate timestamp, HttpStatus status, String mensaje, String ruta) {
        this.timestamp = timestamp;
        this.status = status;
        this.mensaje = mensaje;
        this.ruta = ruta;
    }
}
