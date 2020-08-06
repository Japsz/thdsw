package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PermisoSolicitud;

public interface PermisoSolicitudRepository extends JpaRepository<PermisoSolicitud, Long>{
	void save(Optional<PermisoSolicitud> permisoSolicitudToUpdate);
}
