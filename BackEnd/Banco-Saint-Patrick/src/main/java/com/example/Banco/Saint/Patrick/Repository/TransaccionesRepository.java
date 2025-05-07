package com.example.Banco.Saint.Patrick.Repository;

import com.example.Banco.Saint.Patrick.Model.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransaccionesRepository extends JpaRepository<Transaccion, Long> {

    List<Transaccion> findByOrigenTarjetaId(String id);

    //List<Transaccion> findByDestinoTarjetaId(String numero);

    @Query("SELECT t FROM Transaccion t WHERE t.origenTarjetaId = :id OR t.destinoTarjetaId = :id")
    List<Transaccion> findByTarjetaParticipante(@Param("id") Long id);
}
