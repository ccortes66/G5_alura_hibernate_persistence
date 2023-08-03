package org.example.models.embeblade;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public final class DatosPersonales
{
     private String dni;
     private String nombre;
}
