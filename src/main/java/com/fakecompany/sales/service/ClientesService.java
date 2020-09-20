package com.fakecompany.sales.service;

import com.fakecompany.sales.entity.Cliente;
import com.fakecompany.sales.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Cliente inserir(Cliente cliente) {
        return clientesRepository.save(cliente);
    }

}
