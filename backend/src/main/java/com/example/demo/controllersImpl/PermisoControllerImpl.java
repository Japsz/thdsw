package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.PermisoController;
import com.example.demo.entities.Permiso;
import com.example.demo.service.PermisoService;


@RestController
public class PermisoControllerImpl implements PermisoController {
	@Autowired
	PermisoService permisoService;


	// http://localhost:8888/permisos (GET)
	@RequestMapping(value = "/permisos", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Permiso> getPermisos() {
		return permisoService.findAllPermisos();
	}


	// http://localhost:8888/permisos/1 (GET)
	@Override
	@RequestMapping(value = "/permisos/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Permiso> getPermisoById(@PathVariable Long id) {
		return permisoService.findPermisoById(id);
	}


	// http://localhost:8888/permisos/add (ADD)
	@Override
	@RequestMapping(value = "/permisos/add", method = RequestMethod.POST, produces = "application/json")
	public Permiso addPermiso(Permiso permiso) {
		return permisoService.savePermiso(permiso);
	}


	// http://localhost:8888/permisos/delete/1 (GET)
	@Override
	@RequestMapping(value = "/permisos/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deletePermiso(@PathVariable Long id) {
		return permisoService.deletePermiso(id);
	}


	// http://localhost:8888/permisos/update (PATCH)
	@Override
	@RequestMapping(value = "/permisos/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updatePermiso(Permiso permisoNew) {
		return permisoService.updatePermiso(permisoNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/permisos/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
