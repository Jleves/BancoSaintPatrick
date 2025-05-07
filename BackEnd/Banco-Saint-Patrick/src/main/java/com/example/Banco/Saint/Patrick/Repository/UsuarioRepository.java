package com.example.Banco.Saint.Patrick.Repository;

import com.example.Banco.Saint.Patrick.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
