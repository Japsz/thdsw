package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Empleado;


public interface EmpleadoController {
	public List<Empleado> getEmpleados();


	public Optional<Empleado> getEmpleadoById(Long id);


	public Empleado addEmpleado(Empleado empleado);


	public String deleteEmpleado(Long id);


	public String updateEmpleado(Empleado empleadoNew);


	public String test();
}

