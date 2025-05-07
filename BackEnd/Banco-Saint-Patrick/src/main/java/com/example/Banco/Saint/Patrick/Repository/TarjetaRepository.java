package com.example.Banco.Saint.Patrick.Repository;

import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
    Optional<Tarjeta> findByNumero(String numero);
}
