package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.CertificadoSolicitud;

public interface CertificadoSolicitudService {
	public List<CertificadoSolicitud> findAllCertificadoSolicituds();
	public Optional<CertificadoSolicitud> findCertificadoSolicitudById(Long id);
	public CertificadoSolicitud saveCertificadoSolicitud(CertificadoSolicitud newCertificadoSolicitud);
	public String deleteCertificadoSolicitud(Long id);
	public String updateCertificadoSolicitud(CertificadoSolicitud updatedCertificadoSolicitud);

}
