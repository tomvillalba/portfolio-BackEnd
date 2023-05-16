package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "informacion_personal")
public class InformacionPersonalModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    private Long id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String titulo;

    @Getter @Setter
    private String descripcion;

    @Getter @Setter
    private String banner_url;

    @Getter @Setter
    private String foto_url;
}
