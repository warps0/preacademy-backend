package com.warps.segunda_evaluacion.segunda_evaluacion.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warps.segunda_evaluacion.segunda_evaluacion.exception.RecursoNoEncontradoException;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Profesional;
import com.warps.segunda_evaluacion.segunda_evaluacion.repository.ProfesionalRepository;

@Service
public class ProfesionalServiceImpl implements ProfesionalService {
    @Autowired
    ProfesionalRepository profesionalRepository;

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
        return Optional.ofNullable(profesionalRepository.findById(id)).orElseThrow(
            () -> new RecursoNoEncontradoException("Profesional con id: " + id + " no existe!")
        );
    }

    @Override
    public void deleteById(Long id) {
        profesionalRepository.deleteById(id);
    }

    @Override
    public List<Profesional> findAll() {
        // Si no existen profesionales (lista vacía), se lanza una excepción
        return Optional.ofNullable((List<Profesional>)profesionalRepository.findAll()).orElseThrow(
            () -> new RecursoNoEncontradoException("No se han encontrado profesionales!")
        );
    }

    @Override 
    public List<Profesional> findBySpec(String spec){
        // Si no existen profesionales (lista vacía), se lanza una excepción
        return Optional.ofNullable(profesionalRepository.findBySpec(spec)).orElseThrow(
            () -> new RecursoNoEncontradoException(
                "No se han encontrado profesionales especialistas en " + spec
            )
        );
    }
}
