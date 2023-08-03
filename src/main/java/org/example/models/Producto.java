package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
   private LocalDateTime fechaIngreso = LocalDateTime.now();

   @ManyToOne
   Categoria categoria;

}
