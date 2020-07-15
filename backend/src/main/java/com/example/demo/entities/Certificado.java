package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "certificado")
public class Certificado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcertificado")
	Long Id;
	@Column(name = "tiempoRespuesta")
	Integer tiempoRespuesta;
	@Column(name = "nombre")
	String nombre;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Integer getTiempoRespuesta() {
		return tiempoRespuesta;
	}
	public void setTiempoRespuesta(Integer tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}