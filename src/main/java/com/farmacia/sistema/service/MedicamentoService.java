package com.farmacia.sistema.service;

import com.farmacia.sistema.model.Medicamento;
import com.farmacia.sistema.repository.MedicamentoRepository;
import java.util.List;
import org.springframework.stereotype.Service;

// Servicio: contiene la logica de negocio del modulo medicamentos.
@Service
public class MedicamentoService {

    private final MedicamentoRepository medicamentoRepository;

    // Inyeccion de dependencias por constructor.
    public MedicamentoService(MedicamentoRepository medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    // Lista todos los medicamentos registrados.
    public List<Medicamento> listarTodos() {
        return medicamentoRepository.findAll();
    }

    // Guarda un medicamento nuevo o actualiza uno existente.
    public Medicamento guardar(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    // Busca un medicamento por su id. Si no existe, devuelve null.
    public Medicamento buscarPorId(Integer id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    // Elimina un medicamento por su id.
    public void eliminar(Integer id) {
        medicamentoRepository.deleteById(id);
    }

    // Busca medicamentos por nombre.
    public List<Medicamento> buscarPorNombre(String nombre) {
        return medicamentoRepository.findByNombreContainingIgnoreCase(nombre);
    }
}
