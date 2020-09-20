package com.fakecompany.sales.api;

import com.fakecompany.sales.entity.Cliente;
import com.fakecompany.sales.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ClientesApi {

    @Autowired
    private ClientesService clientesService;

    @PostMapping("clientes")
    public Cliente inserir(@RequestBody Cliente cliente) throws Exception {
        try {
            return this.clientesService.inserir(cliente);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }

}
