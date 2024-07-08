package com.usco.edu.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Usuario implements Serializable {

    private int id;
    private String username;
    private String password;
    private String userdb;
    private boolean state;
    private Uaa uaa;
    private Persona persona;
    private String role;
    private String horaInicioSesion;
    
    private static final long serialVersionUID = 1L;
    
}