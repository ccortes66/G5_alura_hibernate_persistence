package org.example.service;

import org.example.models.Pedido;
import org.example.models.relatorio.RelatorioVentas;
import org.example.repository.PedidoRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoService implements PedidoRepository
{
    private final EntityManager entityManager;

    @Inject
    public PedidoService(EntityManager manager)
    {
        this.entityManager = manager;
    }
    @Override
    public List<Pedido> listar(Long pagina) {
        return null;
    }

    @Override
    public Pedido getById(Long codigo) {
        return entityManager.find(Pedido.class,codigo);
    }

    @Override
    public void guardar(Pedido objeto) {
       entityManager.getTransaction().begin();
       entityManager.persist(objeto);
       entityManager.getTransaction().commit();
    }

    @Override
    public void modificar(Pedido objeto) {

    }

    @Override
    public void eliminar(Long codigo) {

    }

    @Override
    public BigDecimal sumaTotalVentas() {
        String consulta = "SELECT SUM(P.valorTotal) FROM Pedido AS P";
        return entityManager.createQuery(consulta,BigDecimal.class).getSingleResult();
    }

    @Override
    public BigDecimal promedioTotalVenta() {
        String consulta = "SELECT AVG(P.valorTotal) FROM Pedido AS P";
        return entityManager.createQuery(consulta,BigDecimal.class).getSingleResult();
    }

    @Override
    public List<Object[]> relatorioDeVentas() {
        String consulta = new StringBuilder()
                .append("SELECT producto.nombre, SUM(item.cantidad), MAX(pedido.fecha) ")
                .append("FROM Pedido pedido ")
                .append("JOIN pedido.items item ")
                .append("JOIN item.producto producto ")
                .append("GROUP BY producto.nombre ")
                .append("ORDER BY item.cantidad DESC ")
                .toString();
        return entityManager.createQuery(consulta,Object[].class).getResultList();
    }

    @Override
    public List<RelatorioVentas> relatorioDeVentasOp() {
        String consulta = new StringBuilder()
                .append("SELECT new org.example.models.relatorio.RelatorioVentas(producto.nombre, SUM(item.cantidad), MAX(pedido.fecha)) ")
                .append("FROM Pedido pedido ")
                .append("JOIN pedido.items item ")
                .append("JOIN item.producto producto ")
                .append("GROUP BY producto.nombre ")
                .append("ORDER BY item.cantidad DESC ")
                .toString();
        return entityManager.createQuery(consulta,RelatorioVentas.class).getResultList();
    }
}
