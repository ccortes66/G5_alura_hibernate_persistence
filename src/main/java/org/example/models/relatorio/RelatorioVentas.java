package org.example.models.relatorio;

import java.time.LocalDate;

public record RelatorioVentas(String nombre,
                              Long cantidad,
                              LocalDate fecha)
{}
