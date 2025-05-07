package com.example.Banco.Saint.Patrick.Controller.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data

public class SuccessResponse<T> {



        private LocalDateTime timestamp;
        private HttpStatus status;
        private String mensaje;
        private String ruta;
        private T data; // Puede contener cualquier objeto, como DTOs o IDs


        public SuccessResponse() {
        }

        public SuccessResponse(LocalDateTime timestamp, HttpStatus status, String mensaje, String ruta, T data) {
                this.timestamp = timestamp;
                this.status = status;
                this.mensaje = mensaje;
                this.ruta = ruta;
                this.data = data;
        }


        public LocalDateTime getTimestamp() {
                return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
                this.timestamp = timestamp;
        }

        public HttpStatus getStatus() {
                return status;
        }

        public void setStatus(HttpStatus status) {
                this.status = status;
        }

        public String getMensaje() {
                return mensaje;
        }

        public void setMensaje(String mensaje) {
                this.mensaje = mensaje;
        }

        public String getRuta() {
                return ruta;
        }

        public void setRuta(String ruta) {
                this.ruta = ruta;
        }

        public T getData() {
                return data;
        }

        public void setData(T data) {
                this.data = data;
        }
}
