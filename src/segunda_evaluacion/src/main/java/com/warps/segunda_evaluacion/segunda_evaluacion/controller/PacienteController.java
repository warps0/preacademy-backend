package com.warps.segunda_evaluacion.segunda_evaluacion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warps.segunda_evaluacion.segunda_evaluacion.exception.DatoInvalidoException;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Paciente;
import com.warps.segunda_evaluacion.segunda_evaluacion.service.PacienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    PacienteService pacienteService;
    
    @GetMapping
    public List<Paciente> findAll() {
        return pacienteService.findAll();
    }
    
    @GetMapping({"/{id}", "/"})
    public Paciente findById(@PathVariable Optional<Long> id) {
        // Si el id no es válido, se lanza una excepción
        if(id.isPresent()){
            if(id.get() < 0) {
                throw new DatoInvalidoException("El valor de ID debe ser mayor o igual a 0");
            }
        }
        else {
            throw new DatoInvalidoException("Se debe proveer un valor de id a buscar");
        }

        return pacienteService.findById(id.get());
    }
    
    @PostMapping
    public Paciente save(@RequestBody Paciente entity) {
        // Si algun dato no es válido, se lanza una excepción
        return pacienteService.save(entity);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Optional<Long> id) {
        // Si el id no es válido, se lanza una excepción
        if(id.isPresent()){
            if(id.get() < 0) {
                throw new DatoInvalidoException("El valor de ID debe ser mayor o igual a 0");
            }
        }
        else {
            throw new DatoInvalidoException("Se debe proveer un valor de id a buscar");
        }
        
        pacienteService.deleteById(id.get());
    }
}
