package com.example.Banco.Saint.Patrick.Controller;

import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Tarjetas")
public class TarjetaController {
    @Autowired
    private TarjetaService tarjetaService;
    @Autowired
    public TarjetaController(TarjetaService tarjetaService){
        this.tarjetaService = tarjetaService;
    }

    @GetMapping("/tarjeta/{numero}")
    public ResponseEntity<Tarjeta>buscarTarjeta(@PathVariable String numero){
        return ResponseEntity.ok( tarjetaService.buscarPorNumero(numero));
}


}
