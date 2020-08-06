package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.entities.Solicitud;
import com.example.demo.requests.AddSolicitud;


public interface SolicitudController {
	public List<Solicitud> getSolicituds();


	public Optional<Solicitud> getSolicitudById(Long id);


	public Solicitud addSolicitud(AddSolicitud solicitud);


	public String deleteSolicitud(Long id);


	public String updateSolicitud(Solicitud solicitudNew);


	public String test();
	
}

