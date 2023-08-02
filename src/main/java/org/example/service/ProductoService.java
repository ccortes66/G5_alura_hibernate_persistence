package org.example.service;

import org.example.models.Producto;
import org.example.repository.ProductoRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

public final class ProductoService implements ProductoRepository {
    private final EntityManager entityManager;

    @Inject
    public ProductoService(EntityManager manager) {
        this.entityManager = manager;
    }

    @Override
    public List<Producto> listar(Long pagina) {
        Long skip,limit;
        skip = (pagina-1)*10;
        limit = skip + 10;
        String myQuery = "SELECT P FROM Producto AS P";
        TypedQuery<Producto> query = entityManager.createQuery(myQuery,Producto.class);
        query.setFirstResult(skip.intValue());
        query.setMaxResults(limit.intValue());
        return query.getResultList();
    }

    @Override
    public Producto getById(Long codigo) {
        return entityManager.find(Producto.class,codigo);
    }

    @Override
    public void guardar(Producto objeto) {
        entityManager.getTransaction().begin();
        entityManager.persist(objeto);
        entityManager.getTransaction().commit();

    }

    @Override
    public void modificar(Producto objeto) {
        entityManager.getTransaction().begin();
        entityManager.merge(objeto);
        entityManager.getTransaction().commit();

    }

    @Override
    public void eliminar(Long codigo) {
         entityManager.getTransaction().begin();
         entityManager.remove(this.getById(codigo));
         entityManager.getTransaction().commit();
    }

    @Override
    public List<Producto> buscarPorNombre(String nombre) {
        String consulta = "SELECT P FROM Producto AS P WHERE P.nombre=:nombre";
        TypedQuery<Producto> query = entityManager.createQuery(consulta, Producto.class);
        query.setParameter("nombre",nombre);
        return query.getResultList();
    }

    @Override
    public List<Producto> buscarPorNombreCategoria(String nombreCategoria) {
        String consulta = "SELECT P FROM Producto AS P WHERE P.categoria.nombre=:nombreCategoria";
        TypedQuery<Producto> query = entityManager.createQuery(consulta, Producto.class);
        query.setParameter("nombreCategoria",nombreCategoria);
        return query.getResultList();
    }

    @Override
    public BigDecimal buscarPrecioPorNombre(String nombre) {
        String consulta = "SELECT P.precio FROM Producto AS P WHERE P.nombre=:nombre";
        return entityManager.createQuery(consulta,BigDecimal.class)
                                                                  .setParameter("nombre",nombre)
                                                                  .getSingleResult();
    }
}
