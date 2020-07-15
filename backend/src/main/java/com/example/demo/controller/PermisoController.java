package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Permiso;


public interface PermisoController {
	public List<Permiso> getPermisos();


	public Optional<Permiso> getPermisoById(Long id);


	public Permiso addPermiso(Permiso permiso);


	public String deletePermiso(Long id);


	public String updatePermiso(Permiso permisoNew);


	public String test();
}

