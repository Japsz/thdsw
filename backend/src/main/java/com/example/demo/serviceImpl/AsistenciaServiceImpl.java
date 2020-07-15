package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Asistencia;
import com.example.demo.repository.AsistenciaRepository;
import com.example.demo.service.AsistenciaService;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {
	@Autowired
	AsistenciaRepository asistenciaRepository;
	
	@Override
	public List<Asistencia> findAllAsistencias() {
		return asistenciaRepository.findAll();
	}
	
	@Override
	public Optional<Asistencia> findAsistenciaById(Long id) {
		Optional<Asistencia> asistencia = asistenciaRepository.findById(id);
		return asistencia;
	}
	
	@Override
	public Asistencia saveAsistencia(Asistencia newAsistencia) {
		if(newAsistencia != null) {
			return asistenciaRepository.save(newAsistencia);
		}
		return new Asistencia();
	}
	
	@Override
	public String deleteAsistencia(Long id) {
		if(asistenciaRepository.findById(id).isPresent()) {
			asistenciaRepository.deleteById(id);
			return "Customer eliminado correctamente.";
		}
		return "Error! El customer no existe";
	}
	
	@Override
	public String updateAsistencia(Asistencia updatedAsistencia) {
		Long num = updatedAsistencia.getId();
		if(asistenciaRepository.findById(num).isPresent()) {
			asistenciaRepository.save(updatedAsistencia);
			return "Asistencia modificado correctamente";
		}
		return "Asistencia no existe en la BD";
	}
}