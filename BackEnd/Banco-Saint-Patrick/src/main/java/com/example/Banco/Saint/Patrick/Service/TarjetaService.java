package com.example.Banco.Saint.Patrick.Service;

import com.example.Banco.Saint.Patrick.Exceptions.ResourceNotFoundException;
import com.example.Banco.Saint.Patrick.Exceptions.SaldoInsuficienteException;
import com.example.Banco.Saint.Patrick.Model.DTO.TarjetaDTO;
import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Model.Transaccion;
import com.example.Banco.Saint.Patrick.Repository.TarjetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class TarjetaService {


    private TarjetaRepository tarjetaRepository;
    private TransaccionService transaccionService;
    @Autowired
    public TarjetaService(TarjetaRepository tarjetaRepository, TransaccionService transaccionService){
        this.tarjetaRepository = tarjetaRepository;
        this.transaccionService = transaccionService;
    }

    public Optional<TarjetaDTO> buscarPorNumero(String numero) {
        Optional<Tarjeta> tarjetaEncontrada= tarjetaRepository.findByNumero(numero);
        // .orElseThrow(()->new ResourceNotFoundException("Tarjeta no encontrada"))
        tarjetaEncontrada.ifPresent(this::cargarTransacciones);
        return tarjetaEncontrada.map(TarjetaDTO::tarjetaToTarjetaDTO) ;}

    public Tarjeta cargarTransacciones(Tarjeta tarjeta) {
        List<Transaccion> transacciones = transaccionService.obtenerTransaccionesDeTarjeta(tarjeta.getId());
        tarjeta.setTransacciones(transacciones);
        return tarjeta;
    }



    public void realizarTransaccion(String idOrigen, String idDestino, double monto)  {




        Tarjeta buscarTarjetaOrigen = buscarPorNumero(idOrigen)
                .map(TarjetaDTO::tarjetaDTOToTarjeta)
                .orElseThrow(() -> new ResourceNotFoundException("Tarjeta origen no encontrada"));

        if(buscarTarjetaOrigen.getSaldo()>monto){


            Tarjeta buscarTarjetaDestino = buscarPorNumero(idDestino)
                    .map(TarjetaDTO::tarjetaDTOToTarjeta)
                    .orElseThrow(() -> new ResourceNotFoundException("Tarjeta origen no encontrada"));



            if (buscarTarjetaDestino.getSaldo() < monto) {
                throw new SaldoInsuficienteException("Saldo insuficiente en la tarjeta");
        }


            // Realiza la transacción
            buscarTarjetaOrigen.setSaldo(buscarTarjetaOrigen.getSaldo() - monto);
            buscarTarjetaDestino.setSaldo(buscarTarjetaDestino.getSaldo() + monto);


            // Guarda los cambios
            tarjetaRepository.save(buscarTarjetaOrigen);
            tarjetaRepository.save(buscarTarjetaDestino);




        }
    }






}
/**
 public Tarjeta cargarTransacciones(Tarjeta tarjeta) {
 List<Transaccion> transacciones = transaccionRepository.findByTarjetaParticipante(tarjeta.getId());
 tarjeta.setTransacciones(transacciones);
 return tarjeta;
 }**/
