package com.warps.segunda_evaluacion.segunda_evaluacion.service;

import java.util.List;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Paciente;

public interface PacienteService {
    Paciente save(Paciente paciente);
    Paciente findById(Long id);
    void deleteById(Long id);
    List<Paciente> findAll();
}
