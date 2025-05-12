package com.example.Banco.Saint.Patrick.Controller;

import com.example.Banco.Saint.Patrick.Model.DTO.TarjetaDTO;
import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping("/{numero}")
    public ResponseEntity<Optional<TarjetaDTO>>buscarTarjeta(@PathVariable String numero){
        return ResponseEntity.ok(tarjetaService.buscarPorNumero(numero));
}


}
