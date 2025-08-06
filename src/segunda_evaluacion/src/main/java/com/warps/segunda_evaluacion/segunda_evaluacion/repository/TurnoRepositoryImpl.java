package com.warps.segunda_evaluacion.segunda_evaluacion.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Paciente;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Profesional;
import com.warps.segunda_evaluacion.segunda_evaluacion.model.Turno;

@Repository
public class TurnoRepositoryImpl implements TurnoRepository {
    List<Turno> turnos = new java.util.ArrayList<>();

    // Para evitar usar los repositorios de pacientes y profesional en esta implementación
    // Se creeran turnos con los datos de los pacientes y profesionales ya cargados de manera manual

    public TurnoRepositoryImpl() {
        Paciente matias = new Paciente(1L, "Matias", "Trossero", "39504881", "matias.trossero.1@gmail.com");
        Paciente juan = new Paciente(2L, "Juan", "Perez", "12345678", "juan.perez@mail.com");
        Paciente ana = new Paciente(3L, "Ana", "Gomez", "87654321", "ana.gomez@mail.com");
        Paciente luis = new Paciente(4L, "Luis", "Martinez", "11223344", "luis.martinez@mail.com");
        Paciente maria = new Paciente(5L, "Maria", "Lopez", "44332211", "maria.lopez@mail.com");

        Profesional mario = new Profesional(1L, "Mario", "Trujillo", "Clínica");
        Profesional jose = new Profesional(2L, "Jose Maria", "Ramon", "Clínica");
        Profesional robert = new Profesional(3L, "Robert", "Haigh", "Odontología");
        Profesional maya = new Profesional(4L, "Maya Jane", "Coles", "Cardiología");
        Profesional nick = new Profesional(5L, "Nick", "Warren", "Psiquiatría");

        turnos.add(new Turno(1L, maria, nick, LocalDate.of(2025, 11, 25)));
        turnos.add(new Turno(2L, matias, maya, LocalDate.of(2025, 5, 2)));
        turnos.add(new Turno(3L, juan, robert, LocalDate.of(2025, 8, 7)));
        turnos.add(new Turno(4L, ana, mario, LocalDate.of(2025, 8, 13)));
        turnos.add(new Turno(5L, luis, jose, LocalDate.of(2025, 10, 9)));
        turnos.add(new Turno(6L, juan, nick, LocalDate.of(2025, 10, 9)));
    }

    @Override
    public Turno save(Turno entity) {
        turnos.add(entity);
        return entity;
    }

    @Override
    public Turno findById(Long id) {
        // Si no se encuentra, se debe lanza una excepción
        // Por el momento, se retorna null
        return turnos.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        // Implementación para eliminar un Turno por ID
        // Si no se encuentra el ID, se debe lanzar una excepción
        // Por el momento no se hace nada
        turnos.removeIf(p -> p.getId().equals(id));
    }

    @Override
    public Iterable<Turno> findAll() {
        // Implementación para encontrar todos los turnos
        return turnos;
    }

    @Override
    public List<Turno> findByDate(LocalDate date) {
        // Implementación para encontrar todos los turnos por fecha
        return turnos.stream().filter(t -> t.getFecha().equals(date)).toList();
    }
}
