package com.algawork.algaapi.controller;

import com.algawork.algaapi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("clientes")
    public List<Cliente> listar() {
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Diego");
        cliente1.setEmail("diego.dionisio@mail.com");
        cliente1.setTelefone("11 99999-1111");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Ana");
        cliente2.setEmail("ana.venancio@mail.com");
        cliente2.setTelefone("11 90000-1111");

        return Arrays.asList(cliente1, cliente2);
    }
}
