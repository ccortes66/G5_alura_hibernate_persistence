package org.example.models;

import lombok.*;
import org.checkerframework.common.aliasing.qual.Unique;
import org.example.models.embeblade.DatosPersonales;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public final class Cliente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Embedded
    private DatosPersonales datosPersonales;
    private LocalDateTime registo;
}
