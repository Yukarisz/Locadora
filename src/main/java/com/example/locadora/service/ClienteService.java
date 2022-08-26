package com.example.locadora.service;

import com.example.locadora.dto.ClienteDto;
import com.example.locadora.model.Cliente;
import com.example.locadora.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository  clienteRepository;

    public ClienteDto buscarCliente(long id){

        var clienteEntity=clienteRepository.findById(id).get();
        //.orElseThrow(() -> new ChangeSetPersister.NotFoundException());

        return ClienteDto.builder()
                .id(clienteEntity.getId())
                .build();
    }

    public List<ClienteDto> buscarClientes(){

        var clienteEntity=clienteRepository.findAll();
        List<ClienteDto> clientes = new ArrayList<>();
        clienteEntity.forEach(cliente -> {
            ClienteDto clienteDto =  ClienteDto.builder()
                    .id(cliente.getId())
                    .cpf(cliente.getCpf())
                    .nome(cliente.getNome())
                    .endereco(cliente.getEndereco())
                    .build();
            clientes.add(clienteDto);
        });

        return clientes;
    }

    public void salvarCliente(ClienteDto cliente){
        Cliente clienteEntity = Cliente.builder()
                .id(cliente.getId())
                .cpf(cliente.getCpf())
                .nome(cliente.getNome())
                .endereco(cliente.getEndereco())
                .build();

        clienteRepository.save(clienteEntity);
    }

}