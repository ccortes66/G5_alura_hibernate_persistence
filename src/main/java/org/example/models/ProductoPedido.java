package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoPedido
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private BigDecimal precioUnitario;

    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Pedido pedido;


}
