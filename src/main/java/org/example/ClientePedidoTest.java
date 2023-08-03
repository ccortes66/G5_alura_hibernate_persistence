package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.config.AppModule;
import org.example.models.Cliente;
import org.example.models.Pedido;
import org.example.models.Producto;
import org.example.models.ProductoPedido;
import org.example.models.embeblade.DatosPersonales;
import org.example.models.relatorio.RelatorioVentas;
import org.example.repository.ClienteRepository;
import org.example.repository.PedidoRepository;
import org.example.repository.ProductoRepository;
import org.example.service.ClienteService;
import org.example.service.PedidoService;
import org.example.service.ProductoService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class ClientePedidoTest {
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new AppModule());
        ClienteRepository clienteService = injector.getInstance(ClienteService.class);
        PedidoRepository pedidoService = injector.getInstance(PedidoService.class);
        ProductoRepository productoService = injector.getInstance(ProductoService.class);



        /*
        Cliente myCliente = clienteService.getById(2L);

        Producto myproducto = productoService.getById(7L);


        Pedido pedido = new Pedido.Builder()
                                          .Cliente(myCliente)
                                          .build();



       ProductoPedido productoPedido = ProductoPedido.builder()
                                                        .cantidad(5)
                                                        .producto(myproducto)
                                                        .build();


       // pedido.agregarItems(productoPedido);
       // pedidoService.guardar(pedido);

        System.out.println(pedidoService.sumaTotalVentas());

        List<RelatorioVentas> relatorio = pedidoService.relatorioDeVentasOp();
        relatorio.forEach(System.out::println);

         */
        clienteService.guardar(Cliente.builder()
                                               .datosPersonales(new DatosPersonales("112233KKt","Criss15S"))
                                                .registo(LocalDateTime.now())
                                                .build());

    }
}
