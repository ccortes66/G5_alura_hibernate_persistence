package org.example.config;

import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerProvider implements Provider<EntityManager> {

    private final EntityManagerFactory factory;

    public EntityManagerProvider() {
        this.factory = Persistence.createEntityManagerFactory("tienda");
    }

    @Override
    public EntityManager get() {
        return this.factory.createEntityManager();
    }
}
