package com.warps.segunda_evaluacion.segunda_evaluacion.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Paciente;

@Repository
public class PacienteRepository implements MyCrudRepository<Paciente> {
    List<Paciente> pacientes;

    public PacienteRepository() {
        this.pacientes = List.of(
            new Paciente(1L, "Matias", "Trossero", "39504881", "matias.trossero.1@gmail.com"),
            new Paciente(2L, "Juan", "Perez", "12345678", "juan.perez@mail.com"),
            new Paciente(3L, "Ana", "Gomez", "87654321", "ana.gomez@mail.com"),
            new Paciente(4L, "Luis", "Martinez", "11223344", "luis.martinez@mail.com"),
            new Paciente(5L, "Maria", "Lopez", "44332211", "maria.lopez@mail.com")
        );
    }

    @Override
    public Paciente save(Paciente entity) {
        // Implementación para guardar un paciente
        pacientes.add(entity);
        return entity; // Retorna el paciente guardado
    }

    @Override
    public Paciente findById(Long id) {
        // Implementación para encontrar un paciente por ID
        return pacientes.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        // Implementación para eliminar un paciente por ID
        pacientes.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Iterable<Paciente> findAll() {
        // Implementación para encontrar todos los pacientes
        return pacientes; // Retorna una lista de pacientes
    }
}
