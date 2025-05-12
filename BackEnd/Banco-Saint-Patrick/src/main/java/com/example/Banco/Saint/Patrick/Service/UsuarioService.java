package com.example.Banco.Saint.Patrick.Service;

import com.example.Banco.Saint.Patrick.Model.DTO.UserDTO;
import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Model.Usuario;
import com.example.Banco.Saint.Patrick.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService implements UserDetailsService {
    private UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<UserDTO> usuarioId(Long id){
        Optional<Usuario> resultado=usuarioRepository.findById(id);

        System.out.println("Resultado en service   --->  " + resultado);
       return resultado.map(UserDTO::userToUserDTO);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("username antes de buscarlo en el repositorio:   --->" + username);
        Optional<Usuario> buscarUsuario = usuarioRepository.findByUsername(username);
        System.out.println("Usuario buscado en el repositorio: ------>  " + buscarUsuario);
        if(buscarUsuario.isPresent()){
            System.out.println("Load user by Username:  " + buscarUsuario.get().getAuthorities());
            return buscarUsuario.get();

        }else throw new UsernameNotFoundException("No se encontro el usuario");
    }
}
