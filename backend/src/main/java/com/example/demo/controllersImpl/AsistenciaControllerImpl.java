package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.AsistenciaController;
import com.example.demo.entities.Asistencia;
import com.example.demo.service.AsistenciaService;


@RestController
public class AsistenciaControllerImpl implements AsistenciaController {
	@Autowired
	AsistenciaService asistenciaService;


	// http://localhost:8888/asistencias (GET)
	@RequestMapping(value = "/asistencias", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Asistencia> getAsistencias() {
		return asistenciaService.findAllAsistencias();
	}


	// http://localhost:8888/asistencias/1 (GET)
	@Override
	@RequestMapping(value = "/asistencias/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Asistencia> getAsistenciaById(@PathVariable Long id) {
		return asistenciaService.findAsistenciaById(id);
	}


	// http://localhost:8888/asistencias/add (ADD)
	@Override
	@RequestMapping(value = "/asistencias/add", method = RequestMethod.POST, produces = "application/json")
	public Asistencia addAsistencia(Asistencia asistencia) {
		return asistenciaService.saveAsistencia(asistencia);
	}


	// http://localhost:8888/asistencias/delete/1 (GET)
	@Override
	@RequestMapping(value = "/asistencias/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteAsistencia(@PathVariable Long id) {
		return asistenciaService.deleteAsistencia(id);
	}


	// http://localhost:8888/asistencias/update (PATCH)
	@Override
	@RequestMapping(value = "/asistencias/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateAsistencia(Asistencia asistenciaNew) {
		return asistenciaService.updateAsistencia(asistenciaNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/asistencias/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
