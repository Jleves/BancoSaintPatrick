package com.example.Banco.Saint.Patrick.Service;

import com.example.Banco.Saint.Patrick.Model.Transaccion;
import com.example.Banco.Saint.Patrick.Repository.TransaccionesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaccionService {

    public TransaccionesRepository transaccionesRepository;
    @Autowired
    public TransaccionService(TransaccionesRepository transaccionesRepository) {
        this.transaccionesRepository = transaccionesRepository;
    }

    public Transaccion guardarTransaccion(Transaccion transaccion){
       return transaccionesRepository.save(transaccion);
    }


    public List<Transaccion> obtenerTransaccionesDeTarjeta(Long tarjetaId) {
        return transaccionesRepository.findByTarjetaParticipante(tarjetaId);
    }


}
