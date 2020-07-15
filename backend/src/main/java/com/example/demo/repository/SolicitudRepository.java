package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
	void save(Optional<Solicitud> solicitudToUpdate);
}