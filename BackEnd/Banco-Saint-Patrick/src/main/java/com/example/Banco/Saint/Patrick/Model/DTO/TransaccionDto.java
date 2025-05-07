/**package com.example.Banco.Saint.Patrick.Model.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Transacciones")
public class TransaccionDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private double monto;
    private  String moneda;
    private String origenTarjetaId;
    private String destinoTarjetaId;



    public static TransaccionDto transaccionEntrada(TransaccionDto transaccionRequest) {
        TransaccionDto transaccionDto = new TransaccionDto();
        transaccionDto.setFecha(new Date());
        transaccionDto.setFecha(transaccionRequest.getFecha());
        transaccionDto.setMoneda(transaccionDto.getMoneda());
        transaccionDto.setMonto(transaccionRequest.getMonto());
        transaccionDto.setOrigenTarjetaId(transaccionRequest.getOrigenTarjetaId());
        transaccionDto.setDestinoTarjetaId(transaccionRequest.getDestinoTarjetaId());

        return transaccionDto;

    }





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getOrigenTarjetaId() {
        return origenTarjetaId;
    }

    public void setOrigenTarjetaId(String origenTarjetaId) {
        this.origenTarjetaId = origenTarjetaId;
    }

    public String getDestinoTarjetaId() {
        return destinoTarjetaId;
    }

    public void setDestinoTarjetaId(String destinoTarjetaId) {
        this.destinoTarjetaId = destinoTarjetaId;
    }
}
**/