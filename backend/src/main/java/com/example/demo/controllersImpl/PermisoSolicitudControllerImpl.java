package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.PermisoSolicitudController;
import com.example.demo.entities.Permiso;
import com.example.demo.entities.PermisoSolicitud;
import com.example.demo.entities.Solicitud;
import com.example.demo.requests.AddPermisoSolicitud;
import com.example.demo.service.PermisoService;
import com.example.demo.service.PermisoSolicitudService;
import com.example.demo.service.SolicitudService;


@RestController
public class PermisoSolicitudControllerImpl implements PermisoSolicitudController {
	@Autowired
	PermisoSolicitudService permisoSolicitudService;
	@Autowired
	SolicitudService solicitudService;
	@Autowired
	PermisoService permisoService;


	// http://localhost:8888/permisoSolicituds (GET)
	@RequestMapping(value = "/permisoSolicituds", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:8081")
	@Override
	public List<PermisoSolicitud> getPermisoSolicituds() {
		return permisoSolicitudService.findAllPermisoSolicituds();
	}


	// http://localhost:8888/permisoSolicituds/1 (GET)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/permisoSolicituds/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<PermisoSolicitud> getPermisoSolicitudById(@PathVariable Long id) {
		return permisoSolicitudService.findPermisoSolicitudById(id);
	}


	// http://localhost:8888/permisoSolicituds/add (ADD)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/permisoSolicituds/add", method = RequestMethod.POST, produces = "application/json")
	public PermisoSolicitud addPermisoSolicitud(@RequestBody AddPermisoSolicitud request) {
		PermisoSolicitud pSol = new PermisoSolicitud();
		Optional<Solicitud> sol = solicitudService.findSolicitudById(request.idsolicitud);
		Optional<Permiso> permiso = permisoService.findPermisoById(request.idpermiso);
		pSol.setPermiso(permiso.get());
		pSol.setSolicitud(sol.get());
		pSol.setFrom(request.from);
		pSol.setTo(request.to);
		return permisoSolicitudService.savePermisoSolicitud(pSol);
	}


	// http://localhost:8888/permisoSolicituds/delete/1 (GET)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/permisoSolicituds/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deletePermisoSolicitud(@PathVariable Long id) {
		return permisoSolicitudService.deletePermisoSolicitud(id);
	}


	// http://localhost:8888/permisoSolicituds/update (PATCH)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/permisoSolicituds/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updatePermisoSolicitud(PermisoSolicitud permisoSolicitudNew) {
		return permisoSolicitudService.updatePermisoSolicitud(permisoSolicitudNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/permisoSolicituds/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
