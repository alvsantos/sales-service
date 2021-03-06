package com.fakecompany.sales.service;

import com.fakecompany.sales.entity.Cliente;
import com.fakecompany.sales.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Cliente inserir(Cliente cliente) throws Exception {
        if (cliente.getDataNascimento().isBefore(LocalDate.now().minusYears(18))) {
            return clientesRepository.save(cliente);
        } else {
            throw new Exception("Cliente menor de 18 anos.");
        }

    }

    public Iterable<Cliente> listar() {
        return this.clientesRepository.findAll();
    }
}
