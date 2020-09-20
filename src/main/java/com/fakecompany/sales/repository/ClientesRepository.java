package com.fakecompany.sales.repository;

import com.fakecompany.sales.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClientesRepository extends CrudRepository<Cliente, String> {

}
