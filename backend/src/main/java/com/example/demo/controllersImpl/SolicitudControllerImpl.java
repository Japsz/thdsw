package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.SolicitudController;
import com.example.demo.entities.Solicitud;
import com.example.demo.service.SolicitudService;


@RestController
public class SolicitudControllerImpl implements SolicitudController {
	@Autowired
	SolicitudService solicitudService;


	// http://localhost:8888/solicituds (GET)
	@RequestMapping(value = "/solicituds", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Solicitud> getSolicituds() {
		return solicitudService.findAllSolicituds();
	}


	// http://localhost:8888/solicituds/1 (GET)
	@Override
	@RequestMapping(value = "/solicituds/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Solicitud> getSolicitudById(@PathVariable Long id) {
		return solicitudService.findSolicitudById(id);
	}


	// http://localhost:8888/solicituds/add (ADD)
	@Override
	@RequestMapping(value = "/solicituds/add", method = RequestMethod.POST, produces = "application/json")
	public Solicitud addSolicitud(Solicitud solicitud) {
		return solicitudService.saveSolicitud(solicitud);
	}


	// http://localhost:8888/solicituds/delete/1 (GET)
	@Override
	@RequestMapping(value = "/solicituds/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteSolicitud(@PathVariable Long id) {
		return solicitudService.deleteSolicitud(id);
	}


	// http://localhost:8888/solicituds/update (PATCH)
	@Override
	@RequestMapping(value = "/solicituds/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateSolicitud(Solicitud solicitudNew) {
		return solicitudService.updateSolicitud(solicitudNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/solicituds/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
