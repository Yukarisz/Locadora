package com.example.locadora.controller;

import com.example.locadora.dto.ClienteDto;
import com.example.locadora.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;


    @GetMapping("/clientes")
    public List<ClienteDto> getAllNotes() {
        return clienteService.buscarClientes();
    }

    @PostMapping("/clientes")
    public void createCliente(@Valid @RequestBody ClienteDto cliente) {
         clienteService.salvarCliente(cliente);
    }

    @GetMapping("/clientes/{id}")
    public ClienteDto getClienteById(@PathVariable(value = "id") Long clienteId) {
        return clienteService.buscarCliente(clienteId);

    }

}

