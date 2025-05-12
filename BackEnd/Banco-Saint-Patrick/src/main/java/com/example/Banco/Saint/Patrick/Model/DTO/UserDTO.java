package com.example.Banco.Saint.Patrick.Model.DTO;

import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Model.Usuario;
import com.example.Banco.Saint.Patrick.Model.UsuarioRole;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String username;
    private UsuarioRole usuarioRole;
    private List<Tarjeta> tarjetasId= new ArrayList<>();
    private List <String>contactos;


    public static UserDTO userToUserDTO(Usuario user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setUsuarioRole(user.getUsuarioRole());
        userDTO.setTarjetasId(user.getTarjetasId());
        userDTO.setContactos(user.getContactos());
        return userDTO;
    }
    public static Usuario userDTOToUser(UserDTO userDTO) {
        Usuario user = new Usuario();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setUsuarioRole(userDTO.getUsuarioRole());
        user.setTarjetasId(userDTO.getTarjetasId());
        user.setContactos(userDTO.getContactos());
        return user;
    }
}
