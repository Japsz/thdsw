package com.example.demo.controller;

import java.util.List;
import java.util.Optional;
import com.example.demo.entities.Asistencia;


public interface AsistenciaController {
	public List<Asistencia> getAsistencias();


	public Optional<Asistencia> getAsistenciaById(Long id);


	public Asistencia addAsistencia(Asistencia asistencia);


	public String deleteAsistencia(Long id);


	public String updateAsistencia(Asistencia asistenciaNew);


	public String test();
}

