package com.warps.segunda_evaluacion.segunda_evaluacion.service;

import java.time.LocalDate;
import java.util.List;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Turno;

public interface TurnoService {
    Turno save(Turno turno);
    Turno findById(Long id);
    void deleteById(Long id);
    List<Turno> findAll();
    List<Turno> findByDate(LocalDate date);
}
