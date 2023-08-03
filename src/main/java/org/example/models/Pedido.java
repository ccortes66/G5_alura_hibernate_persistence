package org.example.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public final class Pedido
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private LocalDate fecha;
   private BigDecimal valorTotal;


   @ManyToOne
   private Cliente cliente;
   @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
   private List<ProductoPedido> items = new ArrayList<>();

   public Pedido(){}


   public void agregarItems(ProductoPedido item)
   {
      this.valorTotal = item.getProducto().getPrecio().multiply(new BigDecimal(item.getCantidad()));
      this.fecha = LocalDate.now();
      item.setPedido(this);
      this.items.add(item);

   }

   public final static class Builder
   {
       private Pedido pedido;
       public Builder()
       {
          pedido = new Pedido();
       }
       public Builder Cliente(Cliente cliente)
       {
          pedido.cliente = cliente;
          return this;
       }

       public Pedido build()
       {
          return pedido;
       }


   }



}
