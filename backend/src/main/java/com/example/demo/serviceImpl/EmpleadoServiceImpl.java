package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Empleado;
import com.example.demo.repository.EmpleadoRepository;
import com.example.demo.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Override
	public List<Empleado> findAllEmpleados() {
		return empleadoRepository.findAll();
	}
	
	@Override
	public Optional<Empleado> findEmpleadoById(Long id) {
		Optional<Empleado> empleado = empleadoRepository.findById(id);
		return empleado;
	}
	
	@Override
	public Empleado saveEmpleado(Empleado newEmpleado) {
		if(newEmpleado != null) {
			return empleadoRepository.save(newEmpleado);
		}
		return new Empleado();
	}
	
	@Override
	public String deleteEmpleado(Long id) {
		if(empleadoRepository.findById(id).isPresent()) {
			empleadoRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}
	
	@Override
	public String updateEmpleado(Empleado updatedEmpleado) {
		Long num = updatedEmpleado.getId();
		if(empleadoRepository.findById(num).isPresent()) {
			empleadoRepository.save(updatedEmpleado);
			return "Empleado modificado correctamente";
		}
		return "Empleado no existe en la BD";
	}
}
