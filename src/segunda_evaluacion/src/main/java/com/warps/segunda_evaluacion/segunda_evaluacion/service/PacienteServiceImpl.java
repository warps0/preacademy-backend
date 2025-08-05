package com.warps.segunda_evaluacion.segunda_evaluacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warps.segunda_evaluacion.segunda_evaluacion.model.Paciente;
import com.warps.segunda_evaluacion.segunda_evaluacion.repository.MyCrudRepository;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    MyCrudRepository<Paciente> pacienteRepository;

    @Override
    public Paciente save(Paciente paciente) {
        // Lógica para guardar un paciente
        // Si no existe paciente con el ID proporcionado y
        // Si no existe paciente con el mismo DNI, se guarda el paciente
        // se crea uno nuevo (aunque el valor de id a generar podría/debería ser manejado por la base de datos)
        return pacienteRepository.save(paciente);
    }

    @Override
    public Paciente findById(Long id) {
        // Lógica para encontrar un paciente por ID
        // Si no existe paciente con el ID proporcionado, se lanza una excepción
        return pacienteRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        // Lógica para eliminar un paciente por ID
        // Si no existe paciente con el ID proporcionado, se lanza una excepción
        pacienteRepository.deleteById(id);
    }

    @Override
    public List<Paciente> findAll() {
        // Lógica para mostrar todos los pacientes
        // Si no existen pacientes, se lanza una excepción
        return (List<Paciente>) pacienteRepository.findAll();
    }
}
