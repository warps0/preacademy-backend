package com.warps.segunda_evaluacion.segunda_evaluacion.service;

import java.util.List;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Profesional;

public interface ProfesionalService {
    Profesional save(Profesional profesional);
    Profesional findById(Long id);
    void deleteById(Long id);
    List<Profesional> findAll();
}