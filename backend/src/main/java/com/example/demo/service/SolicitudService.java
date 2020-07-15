package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Solicitud;

public interface SolicitudService {
	public List<Solicitud> findAllSolicituds();
	public Optional<Solicitud> findSolicitudById(Long id);
	public Solicitud saveSolicitud(Solicitud newSolicitud);
	public String deleteSolicitud(Long id);
	public String updateSolicitud(Solicitud updatedSolicitud);
	
}