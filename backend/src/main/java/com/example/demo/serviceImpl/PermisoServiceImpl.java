package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Permiso;
import com.example.demo.repository.PermisoRepository;
import com.example.demo.service.PermisoService;

@Service
public class PermisoServiceImpl implements PermisoService {
	@Autowired
	PermisoRepository permisoRepository;
	
	@Override
	public List<Permiso> findAllPermisos() {
		return permisoRepository.findAll();
	}
	
	@Override
	public Optional<Permiso> findPermisoById(Long id) {
		Optional<Permiso> permiso = permisoRepository.findById(id);
		return permiso;
	}
	
	@Override
	public Permiso savePermiso(Permiso newPermiso) {
		if(newPermiso != null) {
			return permisoRepository.save(newPermiso);
		}
		return new Permiso();
	}
	
	@Override
	public String deletePermiso(Long id) {
		if(permisoRepository.findById(id).isPresent()) {
			permisoRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}
	
	@Override
	public String updatePermiso(Permiso updatedPermiso) {
		Long num = updatedPermiso.getId();
		if(permisoRepository.findById(num).isPresent()) {
			permisoRepository.save(updatedPermiso);
			return "Permiso modificado correctamente";
		}
		return "Permiso no existe en la BD";
	}
}
