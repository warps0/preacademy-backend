package com.warps.segunda_evaluacion.segunda_evaluacion.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warps.segunda_evaluacion.segunda_evaluacion.exception.DatoInvalidoException;
import com.warps.segunda_evaluacion.segunda_evaluacion.exception.RecursoNoEncontradoException;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Turno;
import com.warps.segunda_evaluacion.segunda_evaluacion.repository.TurnoRepository;

@Service
public class TurnoServiceImpl implements TurnoService {
    @Autowired
    TurnoRepository turnoRepository;

    @Override
    public Turno save(Turno turno) {
        /*
         Observaciones de la resolución:
            - La validación de paciente y profesional se hacen desde la capa del controlador
            - Se podría trabajar con una única lista, decidí utilizar 2 para una comprensión más clara de la estrategia
            - El mensaje de excepción no es lo suficientemente claro ya que solo utiliza los nombres de las personas involucradas, lo consideré suficiente para esta etápa
        
         Estrategia:
            - Se filtra primero por los turnos de un paciente:
                Esto porque el conjunto de turnos de un paciente es potencialmente menor a todos los turnos de un profesional
                y todos los turnos de un día.
            - A ese conjunto de turnos se lo filtra por los cuales el profesional asignado sea el mismo del turno que se intenta guardar
            - Por último si existe algún turno con mismo paciente, profesional y fecha se lanza la excepción
        */

        List<Turno> turnosDePaciente = ((List<Turno>)turnoRepository.findAll()).stream().filter(
            t -> t.getPaciente().getId().equals(turno.getPaciente().getId())
        ).toList();

        List<Turno> turnosConProfesional = turnosDePaciente.stream().filter(
            t -> t.getProfesional().getId().equals(turno.getProfesional().getId())
        ).toList();

        for (Turno t : turnosConProfesional) {
            if(t.getFecha().equals(turno.getFecha())){
                throw new DatoInvalidoException(
                    "Ya existe un turno para paciente: " + turno.getPaciente().getNombre() +
                    " con profesional: " + turno.getProfesional().getNombre() +
                    " para el: " + turno.getFecha()
                );
            }
        }

        return turnoRepository.save(turno);
    }

    @Override
    public Turno findById(Long id) {
        // Si no existe turno con el ID proporcionado, se lanza una excepción
        return Optional.ofNullable(turnoRepository.findById(id)).orElseThrow(
            () -> new RecursoNoEncontradoException("Turno con id: " + id + " no existe!")
        );
    }

    @Override
    public void deleteById(Long id) {
        // Si no existe turno con el ID proporcionado, se lanza una excepción
        turnoRepository.deleteById(id);
    }

    @Override
    public List<Turno> findAll() {
        // Si no existen turnos (lista vacía), se lanza una excepción
        return Optional.ofNullable((List<Turno>)turnoRepository.findAll()).orElseThrow(
            () -> new RecursoNoEncontradoException("No se han encontrado turnos!")
        );
    }

    @Override 
    public List<Turno> findByDate(LocalDate date){
        // Si no existen turnos (lista vacía), se lanza una excepción
        return Optional.ofNullable(turnoRepository.findByDate(date)).orElseThrow(
            () -> new RecursoNoEncontradoException(
                "No se han encontrado turnos para el: " + date
            )
        );
    }
}
