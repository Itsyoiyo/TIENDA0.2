package com.TiendaII.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private long idCategoria;
    private String descripcion;
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    private boolean activo;

    @OneToMany
    @JoinColumn(name = "id_categoria", updatable = false)
    List<Producto> productos;

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public Categoria() {

    }
}
