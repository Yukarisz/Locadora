package com.example.locadora.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDto {

    private Long id;

    private Long carroId;

    private String cpf;

    private String nome;

    private String endereco;

}
