package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

//java persistence
@Entity
//lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class Producto
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String nombre;
   private String descripcion;
   private BigDecimal precio;

   @ManyToOne
   Categoria categoria;

}
