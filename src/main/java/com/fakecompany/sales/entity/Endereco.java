package com.fakecompany.sales.entity;

import lombok.Data;

@Data
public class Endereco {
    private String rua;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String pais;
    private String estado;
}
