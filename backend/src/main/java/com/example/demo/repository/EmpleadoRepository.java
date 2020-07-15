package com.example.demo.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
	void save(Optional<Empleado> empleadoToUpdate);
}
