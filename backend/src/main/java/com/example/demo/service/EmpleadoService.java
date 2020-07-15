package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Empleado;

public interface EmpleadoService {
	public List<Empleado> findAllEmpleados();
	public Optional<Empleado> findEmpleadoById(Long id);
	public Empleado saveEmpleado(Empleado newEmpleado);
	public String deleteEmpleado(Long id);
	public String updateEmpleado(Empleado updatedEmpleado);
	
}
