package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.CertificadoSolicitud;


public interface CertificadoSolicitudController {
	public List<CertificadoSolicitud> getCertificadoSolicituds();


	public Optional<CertificadoSolicitud> getCertificadoSolicitudById(Long id);


	public CertificadoSolicitud addCertificadoSolicitud(CertificadoSolicitud certificadoSolicitud);


	public String deleteCertificadoSolicitud(Long id);


	public String updateCertificadoSolicitud(CertificadoSolicitud certificadoSolicitudNew);


	public String test();

}

