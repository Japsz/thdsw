package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.PermisoSolicitud;

public interface PermisoSolicitudService {
	public List<PermisoSolicitud> findAllPermisoSolicituds();
	public Optional<PermisoSolicitud> findPermisoSolicitudById(Long id);
	public PermisoSolicitud savePermisoSolicitud(PermisoSolicitud newPermisoSolicitud);
	public String deletePermisoSolicitud(Long id);
	public String updatePermisoSolicitud(PermisoSolicitud updatedPermisoSolicitud);

}
