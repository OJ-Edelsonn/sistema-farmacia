package com.farmacia.sistema.repository;

import com.farmacia.sistema.model.Medicamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repositorio JPA: contiene operaciones CRUD para Medicamento.
@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer> {

    // Busca medicamentos cuyo nombre contenga el texto indicado.
    List<Medicamento> findByNombreContainingIgnoreCase(String nombre);
}
