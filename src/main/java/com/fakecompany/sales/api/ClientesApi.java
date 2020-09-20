package com.fakecompany.sales.api;

import com.fakecompany.sales.entity.Cliente;
import com.fakecompany.sales.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientesApi {

    @Autowired
    private ClientesService clientesService;

    @PostMapping("clientes")
    public Cliente inserir(@RequestBody Cliente cliente){
       return this.clientesService.inserir(cliente);
    }

}
