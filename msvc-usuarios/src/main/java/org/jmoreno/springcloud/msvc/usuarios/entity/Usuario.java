package org.jmoreno.springcloud.msvc.usuarios.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Decorator para definicion de una columna y cracteristicas en tabla
    @Column(name = "nombre")
    private String nombre;

    @Column(unique = true)
    private String email;

    private String password;
}
