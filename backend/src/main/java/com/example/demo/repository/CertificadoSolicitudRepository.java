package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.CertificadoSolicitud;

public interface CertificadoSolicitudRepository extends JpaRepository<CertificadoSolicitud, Long>{
	void save(Optional<CertificadoSolicitud> certificadoSolicitudToUpdate);
}
