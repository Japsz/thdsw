package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Asistencia;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
	void save(Optional<Asistencia> asistenciaToUpdate);
}
