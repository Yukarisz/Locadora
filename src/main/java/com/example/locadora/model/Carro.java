package com.example.locadora.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Entity
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Carro")
public class Carro implements Serializable {
    private static final long serialVersionUID = 1L;

    public Carro(){

    }

    public Carro(Long id, String modelo, String marca, String placa, String cor) {
        this.id = id;
        this.modelo = modelo;
        this.marca = marca;
        this.placa = placa;
        this.cor = cor;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String  modelo;

    @NotBlank
    private String marca;

    @NotBlank
    private String placa;

    @NotBlank
    private String cor;


}
