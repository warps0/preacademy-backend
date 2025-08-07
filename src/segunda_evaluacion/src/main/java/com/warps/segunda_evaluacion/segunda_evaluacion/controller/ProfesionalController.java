package com.warps.segunda_evaluacion.segunda_evaluacion.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warps.segunda_evaluacion.segunda_evaluacion.exception.DatoInvalidoException;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Profesional;
import com.warps.segunda_evaluacion.segunda_evaluacion.service.ProfesionalService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/profesionales")
public class ProfesionalController {
    @Autowired
    ProfesionalService profesionalService;

    @GetMapping
    public List<Profesional> findAll(@RequestParam(required = false) String spec) {
        if(spec == null){
            return profesionalService.findAll();
        }
        else{
            if(spec.isBlank()){
                throw new DatoInvalidoException("Especialización no válida");
            }
            return profesionalService.findBySpec(spec);
        }
    }
    
    @GetMapping({"/{id}", "/"})
    public Profesional findById(@PathVariable Optional<Long> id) {
        // Si el id no es válido, se lanza una excepción
        if(id.isPresent()){
            if(id.get() < 0) {
                throw new DatoInvalidoException("El valor de ID debe ser mayor o igual a 0");
            }
        }
        else {
            throw new DatoInvalidoException("Se debe proveer un valor de id a buscar");
        }

        return profesionalService.findById(id.get());
    }
    
    
    @PostMapping
    public Profesional save(@RequestBody Profesional entity) {
        // Si algun dato no es válido, se lanza una excepción
        return profesionalService.save(entity);
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

        profesionalService.deleteById(id.get());
    }
}
