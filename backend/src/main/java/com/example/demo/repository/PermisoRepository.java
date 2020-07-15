package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Permiso;

public interface PermisoRepository extends JpaRepository<Permiso, Long> {
	void save(Optional<Permiso> permisoToUpdate);
}
