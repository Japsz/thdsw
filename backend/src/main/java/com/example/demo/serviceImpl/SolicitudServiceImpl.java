package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Solicitud;
import com.example.demo.repository.SolicitudRepository;
import com.example.demo.service.SolicitudService;

@Service
public class SolicitudServiceImpl implements SolicitudService {
	@Autowired
	SolicitudRepository solicitudRepository;
	
	@Override
	public List<Solicitud> findAllSolicituds() {
		return solicitudRepository.findAll();
	}
	
	@Override
	public Optional<Solicitud> findSolicitudById(Long id) {
		Optional<Solicitud> solicitud = solicitudRepository.findById(id);
		return solicitud;
	}
	
	@Override
	public Solicitud saveSolicitud(Solicitud newSolicitud) {
		if(newSolicitud != null) {
			return solicitudRepository.save(newSolicitud);
		}
		return new Solicitud();
	}
	
	@Override
	public String deleteSolicitud(Long id) {
		if(solicitudRepository.findById(id).isPresent()) {
			solicitudRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}
	
	@Override
	public String updateSolicitud(Solicitud updatedSolicitud) {
		Long num = updatedSolicitud.getId();
		if(solicitudRepository.findById(num).isPresent()) {
			solicitudRepository.save(updatedSolicitud);
			return "Solicitud modificado correctamente";
		}
		return "Solicitud no existe en la BD";
	}
}
