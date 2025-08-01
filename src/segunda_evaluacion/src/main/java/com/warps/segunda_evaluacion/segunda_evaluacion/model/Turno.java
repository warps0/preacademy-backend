package com.warps.segunda_evaluacion.segunda_evaluacion.model;

import java.time.LocalDate;

public class Turno {
    private Long id;
    private Paciente paciente;
    private Profesional profesional;
    private LocalDate fecha;

    
    // Constructores

    public Turno(Long id, Paciente paciente, Profesional profesional, LocalDate fecha) {
        this.id = id;
        this.paciente = paciente;
        this.profesional = profesional;
        this.fecha = fecha;
    }


    // Getters and Setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Profesional getProfesional() {
        return profesional;
    }
    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
