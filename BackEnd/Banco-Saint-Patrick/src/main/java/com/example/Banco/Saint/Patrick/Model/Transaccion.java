package com.example.Banco.Saint.Patrick.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
                                        @Table(name = "Transacciones")

public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private Date fecha;

private double monto;

private  String moneda;


private String origenTarjetaId;

private String destinoTarjetaId;




    public static Transaccion transaccionEntrada(Transaccion transaccionRequest) {
        Transaccion transaccion = new Transaccion();
        transaccion.setFecha(new Date());
        transaccion.setFecha(transaccionRequest.getFecha());
        transaccion.setMoneda(transaccion.getMoneda());
        transaccion.setMonto(transaccionRequest.getMonto());
        transaccion.setOrigenTarjetaId(transaccionRequest.getOrigenTarjetaId());
        transaccion.setDestinoTarjetaId(transaccionRequest.getDestinoTarjetaId());

        return transaccion;

    }



}
