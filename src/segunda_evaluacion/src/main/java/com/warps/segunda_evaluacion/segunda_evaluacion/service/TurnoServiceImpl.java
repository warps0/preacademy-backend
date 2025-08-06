package com.warps.segunda_evaluacion.segunda_evaluacion.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Turno;
import com.warps.segunda_evaluacion.segunda_evaluacion.repository.TurnoRepository;

@Service
public class TurnoServiceImpl implements TurnoService {
    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public Turno save(Turno turno) {
        // Si no existe turno con el ID proporcionado
        // Y no existe un turno con un mismo profesional/paciente en una misma fecha
        // se guarda el turno
        // (el valor de id a generar podría/debería ser manejado por la base de datos)
        return turnoRepository.save(turno);
    }

    @Override
    public Turno findById(Long id) {
        // Si no existe turno con el ID proporcionado, se lanza una excepción
        return turnoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        // Si no existe turno con el ID proporcionado, se lanza una excepción
        turnoRepository.deleteById(id);
    }

    @Override
    public List<Turno> findAll() {
        // Si no existen turnos (lista vacía), se lanza una excepción
        return (List<Turno>)turnoRepository.findAll();
    }

    @Override 
    public List<Turno> findByDate(LocalDate date){
        // Si no existen turnos (lista vacía), se lanza una excepción
        return turnoRepository.findByDate(date);
    }
}
