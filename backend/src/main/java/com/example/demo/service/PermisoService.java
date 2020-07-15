package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Permiso;

public interface PermisoService {
	public List<Permiso> findAllPermisos();
	public Optional<Permiso> findPermisoById(Long id);
	public Permiso savePermiso(Permiso newPermiso);
	public String deletePermiso(Long id);
	public String updatePermiso(Permiso updatedPermiso);
	
}
