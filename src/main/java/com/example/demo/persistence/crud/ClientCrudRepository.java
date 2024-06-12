package com.example.demo.persistence.crud;

import com.example.demo.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository  extends CrudRepository<Cliente, String> {

}
