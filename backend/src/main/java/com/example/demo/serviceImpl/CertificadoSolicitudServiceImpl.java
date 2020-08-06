package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.CertificadoSolicitud;
import com.example.demo.repository.CertificadoSolicitudRepository;
import com.example.demo.service.CertificadoSolicitudService;

@Service
public class CertificadoSolicitudServiceImpl implements CertificadoSolicitudService {
	@Autowired
	CertificadoSolicitudRepository certificadoSolicitudRepository;

	@Override
	public List<CertificadoSolicitud> findAllCertificadoSolicituds() {
		return certificadoSolicitudRepository.findAll();
	}

	@Override
	public Optional<CertificadoSolicitud> findCertificadoSolicitudById(Long id) {
		Optional<CertificadoSolicitud> certificadoSolicitud = certificadoSolicitudRepository.findById(id);
		return certificadoSolicitud;
	}

	@Override
	public CertificadoSolicitud saveCertificadoSolicitud(CertificadoSolicitud newCertificadoSolicitud) {
		if(newCertificadoSolicitud != null) {
			return certificadoSolicitudRepository.save(newCertificadoSolicitud);
		}
		return new CertificadoSolicitud();
	}

	@Override
	public String deleteCertificadoSolicitud(Long id) {
		if(certificadoSolicitudRepository.findById(id).isPresent()) {
			certificadoSolicitudRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}

	@Override
	public String updateCertificadoSolicitud(CertificadoSolicitud updatedCertificadoSolicitud) {
		Long num = updatedCertificadoSolicitud.getId();
		if(certificadoSolicitudRepository.findById(num).isPresent()) {
			certificadoSolicitudRepository.save(updatedCertificadoSolicitud);
			return "CertificadoSolicitud modificado correctamente";
		}
		return "CertificadoSolicitud no existe en la BD";
	}
}
