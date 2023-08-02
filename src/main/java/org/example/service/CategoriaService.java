package org.example.service;

import org.example.models.Categoria;
import org.example.models.Producto;
import org.example.repository.CategoriaRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoriaService implements CategoriaRepository
{
    private final EntityManager entityManager;

    @Inject
    public CategoriaService(EntityManager manager)
    {
        this.entityManager = manager;
    }

    @Override
    public List<Categoria> listar(Long pagina) {
        Long skip, limit;
        skip = (pagina-1) * 10;
        limit = skip + 10;
        TypedQuery<Categoria> query = entityManager.createQuery("SELECT C FROM Categoria AS C", Categoria.class);
        query.setFirstResult(skip.intValue());
        query.setMaxResults(limit.intValue());
        return query.getResultList();
    }

    @Override
    public Categoria getById(Long codigo) {
         return entityManager.find(Categoria.class,codigo.intValue());
    }

    @Override
    public void guardar(Categoria objeto) {
       entityManager.getTransaction().begin();
       entityManager.persist(objeto);
       entityManager.getTransaction().commit();


    }

    @Override
    public void modificar(Categoria objeto) {
        entityManager.getTransaction().begin();
        entityManager.merge(objeto);
        entityManager.getTransaction().commit();
    }

    @Override
    public void eliminar(Long codigo)
    {
        entityManager.getTransaction().begin();
        entityManager.remove(this.getById(codigo));
        entityManager.getTransaction().commit();
    }
}
