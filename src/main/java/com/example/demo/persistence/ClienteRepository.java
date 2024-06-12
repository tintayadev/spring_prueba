package com.example.demo.persistence;

import com.example.demo.domain.dto.Client;
import com.example.demo.domain.repository.ClientRepository;
import com.example.demo.persistence.crud.ClientCrudRepository;
import com.example.demo.persistence.entity.Cliente;
import com.example.demo.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository implements ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clientCrudRepository.findAll();
        return mapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getClient(String clientId) {
        return clientCrudRepository.findById(clientId)
                .map(cliente -> mapper.toClient(cliente));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = mapper.toCliente(client);
        return mapper.toClient(clientCrudRepository.save(cliente));
    }

    @Override
    public void delete(String clientId) {
        clientCrudRepository.deleteById(clientId);
    }

}
