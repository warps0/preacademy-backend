package com.warps.segunda_evaluacion.segunda_evaluacion.model;

public class Paciente extends Persona {
    private String dni;
    private String email;

    
    // Constructores

    public Paciente(Long id, String nombre, String apellido, String dni, String email) {
        super.setId(id);
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.dni = dni;
        this.email = email;
    }


    // Getters and Setters

    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
