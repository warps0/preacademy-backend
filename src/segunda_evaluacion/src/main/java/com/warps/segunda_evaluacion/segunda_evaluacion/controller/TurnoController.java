package com.warps.segunda_evaluacion.segunda_evaluacion.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warps.segunda_evaluacion.segunda_evaluacion.exception.DatoInvalidoException;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Paciente;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Profesional;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Turno;
import com.warps.segunda_evaluacion.segunda_evaluacion.service.PacienteService;
import com.warps.segunda_evaluacion.segunda_evaluacion.service.ProfesionalService;
import com.warps.segunda_evaluacion.segunda_evaluacion.service.TurnoService;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    TurnoService turnoService;

    @Autowired
    PacienteService pacienteService;

    @Autowired
    ProfesionalService profesionalService;

    @GetMapping
    public List<Turno> findAll() {
        return turnoService.findAll();
    }
    
    @GetMapping({"/{id}", "/"})
    public Turno findById(@PathVariable Optional<Long> id) {
        // Si el id no es válido, se lanza una excepción
        if(id.isPresent()){
            if(id.get() < 0) {
                throw new DatoInvalidoException("El valor de ID debe ser mayor o igual a 0");
            }
        }
        else {
            throw new DatoInvalidoException("Se debe proveer un valor de id a buscar");
        }
        return turnoService.findById(id.get());
    }

    @GetMapping("/fecha/{date}")
    public List<Turno> getMethodName(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return turnoService.findByDate(date);
    }
    
    
    @PostMapping
    public Turno save(@RequestBody Turno turno) {
        // Si algun dato no es válido, se lanza una excepción
        Paciente paciente = turno.getPaciente();
        Profesional profesional = turno.getProfesional();

        /*
         Al hacer uso de los servicios de paciente y profesional
         los cuales soportan las operaciones findById
         en caso de no existir dicho paciente desde sus respecticos servicios
         se lanza una excepción
         Se está dando por sentado que todos los datos del paciente/profesional son correctos
         Respecto a los pacientes/profesionales ya cargados en el sistema con los provistos en el turno
        */ 

        pacienteService.findById(paciente.getId());
        profesionalService.findById(profesional.getId());

        return turnoService.save(turno);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // Si el id no es válido, se lanza una excepción
        turnoService.deleteById(id);
    }
}
