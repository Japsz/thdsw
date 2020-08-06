package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.CertificadoSolicitud;
import com.example.demo.entities.Solicitud;
import com.example.demo.requests.AddCertificadoSolicitud;
import com.example.demo.requests.FillCertificadoSolicitud;


public interface CertificadoSolicitudController {
	public List<CertificadoSolicitud> getCertificadoSolicituds();


	public Optional<CertificadoSolicitud> getCertificadoSolicitudById(Long id);


	public CertificadoSolicitud addCertificadoSolicitud(AddCertificadoSolicitud certificadoSolicitud);


	public String deleteCertificadoSolicitud(Long id);


	public String updateCertificadoSolicitud(CertificadoSolicitud certificadoSolicitudNew);


	public String test();


	public CertificadoSolicitud fillCertificadoSolicitud(Long id, FillCertificadoSolicitud solicitud);

}

