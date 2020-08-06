package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.CertificadoSolicitudController;
import com.example.demo.entities.CertificadoSolicitud;
import com.example.demo.service.CertificadoSolicitudService;


@RestController
public class CertificadoSolicitudControllerImpl implements CertificadoSolicitudController {
	@Autowired
	CertificadoSolicitudService certificadoSolicitudService;


	// http://localhost:8888/certificadoSolicituds (GET)
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/certificadoSolicituds", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<CertificadoSolicitud> getCertificadoSolicituds() {
		return certificadoSolicitudService.findAllCertificadoSolicituds();
	}


	// http://localhost:8888/certificadoSolicituds/1 (GET)
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/certificadoSolicituds/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<CertificadoSolicitud> getCertificadoSolicitudById(@PathVariable Long id) {
		return certificadoSolicitudService.findCertificadoSolicitudById(id);
	}


	// http://localhost:8888/certificadoSolicituds/add (ADD)
	@Override
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/certificadoSolicituds/add", method = RequestMethod.POST, produces = "application/json")
	public CertificadoSolicitud addCertificadoSolicitud(CertificadoSolicitud certificadoSolicitud) {
		return certificadoSolicitudService.saveCertificadoSolicitud(certificadoSolicitud);
	}


	// http://localhost:8888/certificadoSolicituds/delete/1 (GET)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/certificadoSolicituds/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteCertificadoSolicitud(@PathVariable Long id) {
		return certificadoSolicitudService.deleteCertificadoSolicitud(id);
	}


	// http://localhost:8888/certificadoSolicituds/update (PATCH)
	@Override
	@CrossOrigin(origins = "http://localhost:8081")
	@RequestMapping(value = "/certificadoSolicituds/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateCertificadoSolicitud(CertificadoSolicitud certificadoSolicitudNew) {
		return certificadoSolicitudService.updateCertificadoSolicitud(certificadoSolicitudNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/certificadoSolicituds/test", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:8081")
	@Override
	public String test() {
		return "Test done";
	}
}
