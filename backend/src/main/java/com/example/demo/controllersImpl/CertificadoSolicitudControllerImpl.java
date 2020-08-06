package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.CertificadoSolicitudController;
import com.example.demo.entities.Certificado;
import com.example.demo.entities.CertificadoSolicitud;
import com.example.demo.entities.Solicitud;
import com.example.demo.entities.User;
import com.example.demo.requests.AddCertificadoSolicitud;
import com.example.demo.requests.FillCertificadoSolicitud;
import com.example.demo.service.CertificadoService;
import com.example.demo.service.CertificadoSolicitudService;
import com.example.demo.service.SolicitudService;
import com.example.demo.service.UserService;


@RestController
public class CertificadoSolicitudControllerImpl implements CertificadoSolicitudController {
	@Autowired
	CertificadoSolicitudService certificadoSolicitudService;
	@Autowired
	CertificadoService certificadoService;
	@Autowired
	SolicitudService solicitudService;
	@Autowired
	UserService userService;


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
	public CertificadoSolicitud addCertificadoSolicitud(@RequestBody AddCertificadoSolicitud solicitud) {
		Solicitud newSol = new Solicitud();
		CertificadoSolicitud cSol = new CertificadoSolicitud();
		newSol.setStatus(solicitud.status);
		newSol.setType(solicitud.type);
		newSol.setFechaCreacion(solicitud.fechaCreacion);
		Optional<User> user = userService.findUserById(solicitud.iduser);
		newSol.setUser(user.get());
		Solicitud savedSol = solicitudService.saveSolicitud(newSol);
		newSol.setId(savedSol.getId());
		cSol.setSolicitud(newSol);
		Optional<Certificado> certificado = certificadoService.findCertificadoById(solicitud.idcertificado);
		cSol.setCertificado(certificado.get());
		return certificadoSolicitudService.saveCertificadoSolicitud(cSol);
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

	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/certificadoSolicituds/fill/{id}", method = RequestMethod.POST, produces = "application/json")
	@Override
	public CertificadoSolicitud fillCertificadoSolicitud(@PathVariable Long id, @RequestBody FillCertificadoSolicitud solicitud) {
		Optional<CertificadoSolicitud> optcSol = certificadoSolicitudService.findCertificadoSolicitudById(id);
		CertificadoSolicitud cSol = optcSol.get();

		Solicitud sol = cSol.getSolicitud();
		sol.setFechaResolucion(solicitud.fecha);
		sol.setStatus(2);
        String solUpdResponse = solicitudService.updateSolicitud(sol);
        System.out.println(solUpdResponse);
		cSol.setSolicitud(sol);
		cSol.setFileLink(solicitud.fileLink);
		String response = certificadoSolicitudService.updateCertificadoSolicitud(cSol);
        System.out.println(response);
		return cSol;
	}

	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/certificadoSolicituds/test", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = "http://localhost:8081")
	@Override
	public String test() {
		return "Test done";
	}
}
