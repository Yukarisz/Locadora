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
