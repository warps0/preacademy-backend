package com.warps.segunda_evaluacion.segunda_evaluacion.model;

public class Profesional extends Persona{
    String especialidad;

    
    // Constructores

    public Profesional(Long id, String nombre, String apellido, String especialidad) {
        super.setId(id);
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.especialidad = especialidad;
    }


    // Getters and Setters

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
