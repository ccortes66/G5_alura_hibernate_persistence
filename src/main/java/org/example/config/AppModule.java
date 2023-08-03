package org.example.config;

import com.google.inject.AbstractModule;
import org.example.repository.*;
import org.example.service.*;

import javax.persistence.EntityManager;

public class AppModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(EntityManager.class).toProvider(EntityManagerProvider.class);
        bind(ProductoRepository.class).to(ProductoService.class);
        bind(CategoriaRepository.class).to(CategoriaService.class);
        bind(ClienteRepository.class).to(ClienteService.class);
        bind(PedidoRepository.class).to(PedidoService.class);

    }
}


