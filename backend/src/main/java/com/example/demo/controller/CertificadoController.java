package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Certificado;


public interface CertificadoController {
	public List<Certificado> getCertificados();


	public Optional<Certificado> getCertificadoById(Long id);


	public Certificado addCertificado(Certificado certificado);


	public String deleteCertificado(Long id);


	public String updateCertificado(Certificado certificadoNew);


	public String test();
}

