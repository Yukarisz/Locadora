package com.example.locadora.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarroDto {

    private Long id;

    private String modelo;

    private String marca;

    private String placa;

    private String cor;

}
