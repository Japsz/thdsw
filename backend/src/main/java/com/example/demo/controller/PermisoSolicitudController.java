package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.PermisoSolicitud;
import com.example.demo.requests.AddPermisoSolicitud;
import com.example.demo.requests.FillPermisoSolicitud;


public interface PermisoSolicitudController {
	public List<PermisoSolicitud> getPermisoSolicituds();


	public Optional<PermisoSolicitud> getPermisoSolicitudById(Long id);


	public PermisoSolicitud addPermisoSolicitud(AddPermisoSolicitud permisoSolicitud);


	public String deletePermisoSolicitud(Long id);


	public String updatePermisoSolicitud(PermisoSolicitud permisoSolicitudNew);


	public String test();


	PermisoSolicitud fillPermisoSolicitud(Long id, FillPermisoSolicitud solicitud);

}

