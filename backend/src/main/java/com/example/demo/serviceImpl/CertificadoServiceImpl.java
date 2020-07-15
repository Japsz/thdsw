package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Certificado;
import com.example.demo.repository.CertificadoRepository;
import com.example.demo.service.CertificadoService;

@Service
public class CertificadoServiceImpl implements CertificadoService {
	@Autowired
	CertificadoRepository certificadoRepository;
	
	@Override
	public List<Certificado> findAllCertificados() {
		return certificadoRepository.findAll();
	}
	
	@Override
	public Optional<Certificado> findCertificadoById(Long id) {
		Optional<Certificado> certificado = certificadoRepository.findById(id);
		return certificado;
	}
	
	@Override
	public Certificado saveCertificado(Certificado newCertificado) {
		if(newCertificado != null) {
			return certificadoRepository.save(newCertificado);
		}
		return new Certificado();
	}
	
	@Override
	public String deleteCertificado(Long id) {
		if(certificadoRepository.findById(id).isPresent()) {
			certificadoRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}
	
	@Override
	public String updateCertificado(Certificado updatedCertificado) {
		Long num = updatedCertificado.getId();
		if(certificadoRepository.findById(num).isPresent()) {
			certificadoRepository.save(updatedCertificado);
			return "Certificado modificado correctamente";
		}
		return "Certificado no existe en la BD";
	}
}