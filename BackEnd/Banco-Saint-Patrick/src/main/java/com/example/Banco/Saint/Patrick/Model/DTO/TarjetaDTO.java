package com.example.Banco.Saint.Patrick.Model.DTO;

import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Model.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TarjetaDTO {

    private long id;
    private String numero;
    private double saldo;
    private UserDTO usuario;

    public static TarjetaDTO tarjetaToTarjetaDTO(Tarjeta tarjeta){
        TarjetaDTO tarjetaDTO= new TarjetaDTO();
        tarjetaDTO.setId(tarjeta.getId());
        tarjetaDTO.setNumero(tarjeta.getNumero());
        UserDTO userDTO = UserDTO.userToUserDTO(tarjeta.getUsuario());
        tarjetaDTO.setUsuario(userDTO);
        tarjetaDTO.setSaldo(tarjeta.getSaldo());
        return tarjetaDTO;
    }

    //UserDTO::userToUserDTO

    public static Tarjeta tarjetaDTOToTarjeta(TarjetaDTO dto) {
        Tarjeta tarjeta = new Tarjeta();
        tarjeta.setId(dto.getId());
        tarjeta.setNumero(dto.getNumero());
        tarjeta.setSaldo(dto.getSaldo());
        Usuario usuario = UserDTO.userDTOToUser(dto.getUsuario());
        tarjeta.setUsuario(usuario);
        return tarjeta;
    }
}
