package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Certificado;

public interface CertificadoRepository extends JpaRepository<Certificado, Long> {
	void save(Optional<Certificado> certificadoToUpdate);
}