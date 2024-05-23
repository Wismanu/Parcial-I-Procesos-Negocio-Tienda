package com.tienda.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    @NotNull
    @NotBlank
    private String nombre;

    @Column(length = 250)
    private String descripcion;

    @Column(length = 250)
    @NotNull
    @NotBlank
    private String marca;

    private Integer meses_garantia;

    @NotNull
    @NotBlank
    private Double  precio;

    private String imagenUrl;

    @ManyToOne
    @NotNull
    @NotBlank
    @JoinColumn(referencedColumnName = "categoria_id")
    private Categoria categoria;

}
