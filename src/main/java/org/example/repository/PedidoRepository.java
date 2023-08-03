package org.example.repository;

import org.example.models.Pedido;
import org.example.models.relatorio.RelatorioVentas;
import org.example.service.CrudImplementable;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoRepository extends CrudImplementable<Pedido,Long>
{
    BigDecimal sumaTotalVentas();
    BigDecimal promedioTotalVenta();
    List<Object[]> relatorioDeVentas();
    List<RelatorioVentas> relatorioDeVentasOp();
}
