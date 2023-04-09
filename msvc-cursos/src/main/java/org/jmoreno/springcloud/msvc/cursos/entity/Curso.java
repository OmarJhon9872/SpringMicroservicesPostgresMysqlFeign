package org.jmoreno.springcloud.msvc.cursos.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cursos")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
}
