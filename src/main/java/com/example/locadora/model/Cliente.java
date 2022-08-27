package com.example.locadora.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "Clientes")
public class Cliente {

    public Cliente(){

    }

    public Cliente(Long id,Carro idCarro, String cpf, String nome, String endereco) {
        this.id = id;
        this.idCarro = idCarro;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Carro idCarro;

    @NotBlank
    @Column
    private String cpf;

    @NotBlank
    @Column
    private String nome;

    @NotBlank
    @Column
    private String endereco;


}

