package org.example.config;

import com.google.inject.AbstractModule;
import org.example.repository.CategoriaRepository;
import org.example.repository.ProductoRepository;
import org.example.service.CategoriaService;
import org.example.service.CrudImplementable;
import org.example.service.ProductoService;

import javax.persistence.EntityManager;

public class AppModule extends AbstractModule
{
    @Override
    protected void configure() {
        bind(EntityManager.class).toProvider(EntityManagerProvider.class);
        bind(ProductoRepository.class).to(ProductoService.class);
        bind(CategoriaRepository.class).to(CategoriaService.class);
    }
}


