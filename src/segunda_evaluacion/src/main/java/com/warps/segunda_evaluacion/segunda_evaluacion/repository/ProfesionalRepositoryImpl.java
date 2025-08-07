package com.warps.segunda_evaluacion.segunda_evaluacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Profesional;

@Repository
public class ProfesionalRepositoryImpl implements ProfesionalRepository {
    List<Profesional> profesionales = new java.util.ArrayList<>();

    public ProfesionalRepositoryImpl() {
        profesionales.add(new Profesional(1L, "Mario", "Trujillo", "Clínica"));
        profesionales.add(new Profesional(2L, "Jose Maria", "Ramon", "Clínica"));
        profesionales.add(new Profesional(3L, "Robert", "Haigh", "Odontología"));
        profesionales.add(new Profesional(4L, "Maya Jane", "Coles", "Cardiología"));
        profesionales.add(new Profesional(5L, "Nick", "Warren", "Psiquiatría"));
    }

    @Override
    public Profesional save(Profesional entity) {
        profesionales.add(entity);
        return entity; // Aquí se debería agregar la lógica de persistencia
    }

    @Override
    public Profesional findById(Long id) {
        // Si no se encuentra, se debe lanza una excepción
        // Por el momento, se retorna null
        return profesionales.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        // Implementación para eliminar un Profesional por ID
        // Si no se encuentra el ID, se debe lanzar una excepción
        // Por el momento no se hace nada
        profesionales.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Iterable<Profesional> findAll() {
        // Implementación para encontrar todos los Profesionales
        if(profesionales.isEmpty()) return null;
        return profesionales;
    }

    @Override
    public List<Profesional> findBySpec(String spec) {
        List<Profesional> especialistas = profesionales.stream().filter(p -> p.getEspecialidad().equals(spec)).toList();

        if(especialistas.isEmpty()) return null;

        return especialistas;
    }
}
