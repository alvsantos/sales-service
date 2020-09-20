package com.fakecompany.sales.api;

import com.fakecompany.sales.entity.Cliente;
import com.fakecompany.sales.service.ClientesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClientesApi {

    @Autowired
    private ClientesService clientesService;

    @PostMapping
    public Cliente inserir(@RequestBody Cliente cliente) throws Exception {
        try {
            return this.clientesService.inserir(cliente);
        }
        catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
    }

    @GetMapping
    public Iterable<Cliente> listar() {
        return this.clientesService.listar();
    }

}
