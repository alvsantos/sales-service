package com.fakecompany.sales.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Endereco {
    @Id
    @JsonProperty
    private String id;

    @JsonProperty
    private String rua;

    @JsonProperty
    private String numero;

    @JsonProperty
    private String cep;

    @JsonProperty
    private String bairro;

    @JsonProperty
    private String cidade;

    @JsonProperty
    private String pais;

    @JsonProperty
    private String estado;
}
