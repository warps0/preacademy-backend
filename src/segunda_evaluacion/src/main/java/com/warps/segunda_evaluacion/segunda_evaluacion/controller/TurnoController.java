package com.warps.segunda_evaluacion.segunda_evaluacion.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Turno;
import com.warps.segunda_evaluacion.segunda_evaluacion.service.TurnoService;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    TurnoService turnoService;

    @GetMapping
    public List<Turno> findAll() {
        return turnoService.findAll();
    }
    
    @GetMapping("/{id}")
    public Turno findById(@PathVariable Long id) {
        // Si el id no es válido, se lanza una excepción
        return turnoService.findById(id);
    }

    @GetMapping("/fecha/{date}")
    public List<Turno> getMethodName(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return turnoService.findByDate(date);
    }
    
    
    @PostMapping
    public Turno save(@RequestBody Turno entity) {
        // Si algun dato no es válido, se lanza una excepción
        return turnoService.save(entity);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        // Si el id no es válido, se lanza una excepción
        turnoService.deleteById(id);
    }
}
