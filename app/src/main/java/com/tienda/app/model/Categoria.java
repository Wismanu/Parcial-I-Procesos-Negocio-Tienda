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
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoria_id")
    private Integer categoriaId;

    @Column(length = 100)
    @NotNull
    @NotBlank
    private String nombre;

    @Column(length = 250)
    @NotNull
    @NotBlank
    private String descripcion;

    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
    }

//    @OneToMany(mappedBy = "categoria")
//    private List<Producto> productos;

}