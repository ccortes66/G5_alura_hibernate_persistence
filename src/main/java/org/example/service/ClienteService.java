package org.example.service;

import org.example.models.Cliente;
import org.example.repository.ClienteRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class ClienteService implements ClienteRepository
{
    private final EntityManager entityManager;

    @Inject
    public ClienteService(EntityManager manager)
    {
      this.entityManager = manager;
    }
    @Override
    public List<Cliente> listar(Long pagina) {
        return null;
    }

    @Override
    public Cliente getById(Long codigo) {
        return entityManager.find(Cliente.class,codigo);
    }

    @Override
    public void guardar(Cliente objeto) {
       entityManager.getTransaction().begin();
       entityManager.persist(objeto);
       entityManager.getTransaction().commit();
    }

    @Override
    public void modificar(Cliente objeto) {

    }

    @Override
    public void eliminar(Long codigo) {

    }
}
