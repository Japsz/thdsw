package com.example.demo.controllersImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.controller.CertificadoController;
import com.example.demo.entities.Certificado;
import com.example.demo.service.CertificadoService;


@RestController
public class CertificadoControllerImpl implements CertificadoController {
	@Autowired
	CertificadoService certificadoService;


	// http://localhost:8888/certificados (GET)
	@RequestMapping(value = "/certificados", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Certificado> getCertificados() {
		return certificadoService.findAllCertificados();
	}


	// http://localhost:8888/certificados/1 (GET)
	@Override
	@RequestMapping(value = "/certificados/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Certificado> getCertificadoById(@PathVariable Long id) {
		return certificadoService.findCertificadoById(id);
	}


	// http://localhost:8888/certificados/add (ADD)
	@Override
	@RequestMapping(value = "/certificados/add", method = RequestMethod.POST, produces = "application/json")
	public Certificado addCertificado(Certificado certificado) {
		return certificadoService.saveCertificado(certificado);
	}


	// http://localhost:8888/certificados/delete/1 (GET)
	@Override
	@RequestMapping(value = "/certificados/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteCertificado(@PathVariable Long id) {
		return certificadoService.deleteCertificado(id);
	}


	// http://localhost:8888/certificados/update (PATCH)
	@Override
	@RequestMapping(value = "/certificados/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateCertificado(Certificado certificadoNew) {
		return certificadoService.updateCertificado(certificadoNew);
	}


	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/certificados/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test done";
	}
}
