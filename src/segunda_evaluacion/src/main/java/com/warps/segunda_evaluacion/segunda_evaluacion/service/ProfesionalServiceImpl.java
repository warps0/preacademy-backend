package com.warps.segunda_evaluacion.segunda_evaluacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Profesional;
import com.warps.segunda_evaluacion.segunda_evaluacion.repository.MyCrudRepository;

@Service
public class ProfesionalServiceImpl implements ProfesionalService {
    @Autowired
    MyCrudRepository<Profesional> profesionalRepository;

    @Override
    public Profesional save(Profesional profesional) {
        // Si no existe profesional con el ID proporcionado
        // se guarda el profesional
        // (el valor de id a generar podría/debería ser manejado por la base de datos)
        return profesionalRepository.save(profesional);
    }

    @Override
    public Profesional findById(Long id) {
        // Si no existe profesional con el ID proporcionado, se lanza una excepción
        return profesionalRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        // Si no existe profesional con el ID proporcionado, se lanza una excepción
        profesionalRepository.deleteById(id);
    }

    @Override
    public List<Profesional> findAll() {
        // Si no existen profesionales (lista vacía), se lanza una excepción
        return (List<Profesional>)profesionalRepository.findAll();
    }
}
