package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.EmpleadoController;
import com.example.demo.entities.Empleado;
import com.example.demo.service.EmpleadoService;


@RestController
public class EmpleadoControllerImpl implements EmpleadoController {
	@Autowired
	EmpleadoService empleadoService;


	// http://localhost:8888/empleados (GET)
	@RequestMapping(value = "/empleados", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Empleado> getEmpleados() {
		return empleadoService.findAllEmpleados();
	}


	// http://localhost:8888/empleados/1 (GET)
	@Override
	@RequestMapping(value = "/empleados/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Empleado> getEmpleadoById(@PathVariable Long id) {
		return empleadoService.findEmpleadoById(id);
	}


	// http://localhost:8888/empleados/add (ADD)
	@Override
	@RequestMapping(value = "/empleados/add", method = RequestMethod.POST, produces = "application/json")
	public Empleado addEmpleado(Empleado empleado) {
		return empleadoService.saveEmpleado(empleado);
	}


	// http://localhost:8888/empleados/delete/1 (GET)
	@Override
	@RequestMapping(value = "/empleados/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteEmpleado(@PathVariable Long id) {
		return empleadoService.deleteEmpleado(id);
	}


	// http://localhost:8888/empleados/update (PATCH)
	@Override
	@RequestMapping(value = "/empleados/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateEmpleado(Empleado empleadoNew) {
		return empleadoService.updateEmpleado(empleadoNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/empleados/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
