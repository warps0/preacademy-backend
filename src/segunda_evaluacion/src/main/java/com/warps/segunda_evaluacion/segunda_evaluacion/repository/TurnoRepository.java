package com.warps.segunda_evaluacion.segunda_evaluacion.repository;

import java.time.LocalDate;
import java.util.List;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Turno;

public interface TurnoRepository extends MyCrudRepository<Turno> {
    public List<Turno> findByDate(LocalDate date);
}
