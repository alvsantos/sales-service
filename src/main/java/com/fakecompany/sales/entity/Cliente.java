package com.fakecompany.sales.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Cliente {
    @Id
    @JsonProperty
    private String id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String email;

    @JsonProperty
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Endereco> enderecos;

    @JsonProperty
    private String telefone;

    @JsonProperty
    private Date dataNascimento;

    @JsonProperty
    private String cpf;
}
