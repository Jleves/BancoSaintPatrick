package com.example.Banco.Saint.Patrick.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;


@Entity
@AllArgsConstructor
@Data
@Table(name = "Tarjetas")
public class Tarjeta {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String numero;

    @Column(nullable = false)
    private double saldo;


    @ManyToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    @JsonBackReference
    private Usuario usuario;

/** Guardando lista de transacciones en el repositorio de tarjetas



    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "origenTarjetaId") // "mapea" el campo que está en Transaccion
    private List<Transaccion> transaccionesOrigen;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "destinoTarjetaId")
    private List<Transaccion> transaccionesDestino;
 **/

/**
                             Tabla dinamica

 Realizando tabla dinamica en tiempo de ejecucion donde buscamos las transacciones
 en el repositorio de transacciones y las mostramos. **/

 // Esta lista no se guarda ni se carga automáticamente desde la base de datos


 @Transient
 private List<Transaccion> transacciones;





    public Tarjeta(double saldo, Usuario usuarioId) {
        this.saldo = saldo;
        this.usuario = usuarioId;
    }

    public Tarjeta() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
