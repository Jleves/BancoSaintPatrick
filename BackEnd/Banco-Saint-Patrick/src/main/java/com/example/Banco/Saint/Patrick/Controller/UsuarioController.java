package com.example.Banco.Saint.Patrick.Controller;

import com.example.Banco.Saint.Patrick.Exceptions.ResourceNotFoundException;
import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Model.Usuario;
import com.example.Banco.Saint.Patrick.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }




    @GetMapping("/{id}")
    public ResponseEntity<Usuario>buscarUsuarioId(@PathVariable Long id){

        ResponseEntity<Usuario> resultado= ResponseEntity.ok(usuarioService.usuarioId(id).orElseThrow(()->new ResourceNotFoundException("Usuario no encontrado")));
        System.out.println("Resultado en controller   --->  " + resultado);
        return resultado;
    }


}
