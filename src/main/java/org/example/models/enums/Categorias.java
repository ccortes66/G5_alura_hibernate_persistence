package org.example.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
public enum Categorias
{
    CELULARES("Celulares"),
    COMPUTADORES("Computadores");

    @Setter  @Getter
    private final String nombre;


}
