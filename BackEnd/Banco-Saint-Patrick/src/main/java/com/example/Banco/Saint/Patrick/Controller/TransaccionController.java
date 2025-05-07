package com.example.Banco.Saint.Patrick.Controller;

import com.example.Banco.Saint.Patrick.Controller.Response.SuccessResponse;
import com.example.Banco.Saint.Patrick.Exceptions.ResourceNotFoundException;

import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Model.Transaccion;
import com.example.Banco.Saint.Patrick.Service.TarjetaService;
import com.example.Banco.Saint.Patrick.Service.TransaccionService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Transaccion")
public class TransaccionController {

    private TarjetaService tarjetaService;
    private TransaccionService transaccionService;
    @Autowired
    public TransaccionController(TarjetaService tarjetaService, TransaccionService transaccionService) {
        this.tarjetaService = tarjetaService;
        this.transaccionService = transaccionService;
    }




    @PostMapping("/newTransfer")
    public ResponseEntity<SuccessResponse<String>> transferirSaldo(@RequestBody Transaccion transaccionDtoEntrada, HttpServletRequest request)
    {


        Transaccion transaccionDto = Transaccion.transaccionEntrada(transaccionDtoEntrada);


        Tarjeta tarjetaOrigen = tarjetaService.buscarPorNumero(transaccionDto.getOrigenTarjetaId());


        Tarjeta tarjetaDestino = tarjetaService.buscarPorNumero(transaccionDto.getDestinoTarjetaId());


            tarjetaService.realizarTransaccion(tarjetaOrigen.getNumero(),tarjetaDestino.getNumero(),transaccionDto.getMonto());
            String respuesta = "Transacción realizada con éxito.\n" +
                    "Transacción número: " + transaccionDto.getId() + "\n" +
                    "Tarjeta Origen: " + transaccionDto.getOrigenTarjetaId() + "\n" +
                    "Tarjeta Destino: " + transaccionDto.getDestinoTarjetaId() + "\n" +
                    "Monto: " + transaccionDto.getMonto() + "\n" +
                    "Saldo actual: " + tarjetaOrigen.getSaldo();



        SuccessResponse<String> response = new SuccessResponse<>(
                LocalDateTime.now(),
                HttpStatus.CREATED,
                "Transferencia procesada exitosamente",
                request.getRequestURI(),
                respuesta
        );
        transaccionService.guardarTransaccion(transaccionDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);




    }
}
