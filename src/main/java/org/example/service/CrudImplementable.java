package org.example.service;

import org.example.models.Producto;

import java.util.List;

public interface CrudImplementable<T,E>
{
    List<T> listar(Long pagina);
    T getById(E codigo);
    void guardar(T objeto);
    void modificar(T objeto);
    void eliminar(E codigo);

}

