package com.warps.segunda_evaluacion.segunda_evaluacion.repository;

import java.util.List;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Profesional;

public interface ProfesionalRepository extends MyCrudRepository<Profesional> {
    public List<Profesional> findBySpec(String speciality);
}
