package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.PermisoSolicitud;
import com.example.demo.repository.PermisoSolicitudRepository;
import com.example.demo.service.PermisoSolicitudService;

@Service
public class PermisoSolicitudServiceImpl implements PermisoSolicitudService {
	@Autowired
	PermisoSolicitudRepository permisoSolicitudRepository;

	@Override
	public List<PermisoSolicitud> findAllPermisoSolicituds() {
		return permisoSolicitudRepository.findAll();
	}

	@Override
	public Optional<PermisoSolicitud> findPermisoSolicitudById(Long id) {
		Optional<PermisoSolicitud> permisoSolicitud = permisoSolicitudRepository.findById(id);
		return permisoSolicitud;
	}

	@Override
	public PermisoSolicitud savePermisoSolicitud(PermisoSolicitud newPermisoSolicitud) {
		if(newPermisoSolicitud != null) {
			return permisoSolicitudRepository.save(newPermisoSolicitud);
		}
		return new PermisoSolicitud();
	}

	@Override
	public String deletePermisoSolicitud(Long id) {
		if(permisoSolicitudRepository.findById(id).isPresent()) {
			permisoSolicitudRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}

	@Override
	public String updatePermisoSolicitud(PermisoSolicitud updatedPermisoSolicitud) {
		Long num = updatedPermisoSolicitud.getId();
		if(permisoSolicitudRepository.findById(num).isPresent()) {
			permisoSolicitudRepository.save(updatedPermisoSolicitud);
			return "PermisoSolicitud modificado correctamente";
		}
		return "PermisoSolicitud no existe en la BD";
	}
}
