package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "soft_skills")
public class SoftSkillsModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    @Getter
    @Setter
    private Integer id;
    @Getter @Setter
    private String titulo;
    @Getter @Setter
    private Integer porcentaje;

}
