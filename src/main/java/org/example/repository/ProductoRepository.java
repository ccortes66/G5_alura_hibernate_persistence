package org.example.repository;

import org.example.models.Producto;
import org.example.service.CrudImplementable;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoRepository extends CrudImplementable<Producto,Long>
{

    List<Producto> buscarPorNombre(String nombre);
    List<Producto> buscarPorNombreCategoria(String nombreCategoria);
    BigDecimal buscarPrecioPorNombre(String nombre);
}
