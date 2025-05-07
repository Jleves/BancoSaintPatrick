package com.example.Banco.Saint.Patrick;

import com.example.Banco.Saint.Patrick.Model.Tarjeta;
import com.example.Banco.Saint.Patrick.Model.Usuario;
import com.example.Banco.Saint.Patrick.Repository.TarjetaRepository;
import com.example.Banco.Saint.Patrick.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Datainitializer implements CommandLineRunner {
    private final UsuarioRepository usuarioRepository;
    private final TarjetaRepository tarjetaRepository;
    @Autowired
    public Datainitializer(UsuarioRepository usuarioRepository, TarjetaRepository tarjetaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.tarjetaRepository = tarjetaRepository;
    }

    @Override
    public void run(String... args) throws Exception {



//.usuarioRole(UsuarioRole.USER) --> asignar rol de usuario


        Usuario usuario1= new Usuario();
        usuario1.setPin(4345);
        Tarjeta tarjeta1= new Tarjeta(40555, usuario1);
        tarjeta1.setNumero("4546-8574-1856-5565");


        Usuario usuario2 = new Usuario();
        usuario2.setPin(1595);
        Tarjeta tarjeta2= new Tarjeta(3566, usuario2);
        tarjeta2.setNumero("5595-3458-9989-7125");




        Usuario usuario3 = new Usuario();
        usuario3.setPin(1234);
        Tarjeta tarjeta3= new Tarjeta(3566, usuario3);
        tarjeta3.setNumero("4858-6696-5887-1578");

        Usuario usuario4 = new Usuario();
        usuario4.setPin(4345);
        Tarjeta tarjeta4= new Tarjeta(300, usuario4);
        tarjeta4.setNumero("5854-6656-2587-1547");


        Usuario usuario5 = new Usuario();
        usuario5.setPin(0023);
        Tarjeta tarjeta5= new Tarjeta(35621, usuario5);
        tarjeta5.setNumero("4546-9896-2357-1478");

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
        usuarioRepository.save(usuario3);
        usuarioRepository.save(usuario4);
        usuarioRepository.save(usuario5);


        tarjetaRepository.save(tarjeta1);
        tarjetaRepository.save(tarjeta2);
        tarjetaRepository.save(tarjeta3);
        tarjetaRepository.save(tarjeta4);
        tarjetaRepository.save(tarjeta5);

    }
}
