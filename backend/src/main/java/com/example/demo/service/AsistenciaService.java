package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Asistencia;

public interface AsistenciaService {
	public List<Asistencia> findAllAsistencias();
	public Optional<Asistencia> findAsistenciaById(Long id);
	public Asistencia saveAsistencia(Asistencia newAsistencia);
	public String deleteAsistencia(Long id);
	public String updateAsistencia(Asistencia updatedAsistencia);
	
}
