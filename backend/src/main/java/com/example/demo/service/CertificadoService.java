package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Certificado;

public interface CertificadoService {
	public List<Certificado> findAllCertificados();
	public Optional<Certificado> findCertificadoById(Long id);
	public Certificado saveCertificado(Certificado newCertificado);
	public String deleteCertificado(Long id);
	public String updateCertificado(Certificado updatedCertificado);
	
}
