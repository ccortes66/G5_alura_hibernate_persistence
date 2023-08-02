package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.config.AppModule;
import org.example.models.Categoria;
import org.example.models.Producto;
import org.example.models.enums.Categorias;
import org.example.repository.CategoriaRepository;
import org.example.repository.ProductoRepository;
import org.example.service.CategoriaService;
import org.example.service.CrudImplementable;
import org.example.service.ProductoService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args)
    {
        /*
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(Producto.builder()
                                       .nombre("Samsung S21")
                                       .descripcion("Telefono reacondicionado")
                                       .precio(new BigDecimal(500.99))
                                       .build());
        entityManager.getTransaction().commit();
        entityManager.close();

         */

        //creando el inyector
        Injector injector = Guice.createInjector(new AppModule());
        ProductoRepository productoService = injector.getInstance(ProductoService.class);
        CategoriaRepository categoriaService = injector.getInstance(CategoriaService.class);

        Categoria celular = Categoria.builder().nombre(Categorias.CELULARES.getNombre())
                                                                                     .build();

        /*
        List<Producto> productos = productoService.listar(1l);
        productos.forEach(data -> System.out.println(data.getNombre()));
        productos.clear();
        productos = productoService.buscarPorNombre("Samsung S21");
        productos.forEach(data -> System.out.println(data.getNombre()));
        productos.clear();
        productos = productoService.buscarPorNombreCategoria(Categorias.CELULARES.getNombre());
        productos.forEach(data -> System.out.println(data.getCategoria().getNombre()));

        System.out.println(productoService.buscarPrecioPorNombre("Xiaomi Poco m3 x"));
        productoService.eliminar(8L);
        */
        List<Categoria> categorias = categoriaService.listar(1L);
        categorias.forEach(System.out::println);

        System.out.println(categoriaService.getById(2L));
        /*categoriaService.guardar(Categoria.builder().nombre(Categorias.COMPUTADORES.getNombre()).build());*/

        categoriaService.eliminar(3L);

    }
}