package com.fakecompany.sales.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Cliente {
    private String nome;
    private String email;
    private List<Endereco> enderecos;
    private String id;
    private String telefone;
    private Date dataNascimento;
    private String cpf;
}
