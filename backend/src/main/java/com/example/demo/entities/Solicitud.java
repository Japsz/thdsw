package com.example.demo.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "solicitud")
public class Solicitud {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idsolicitud")
	Long Id;
	@ManyToOne
	@JoinColumn(name = "iduser", nullable=false)
	private User user;
	@Column(name = "type")
	Integer type;
	@Column(name = "status")
	Integer status;
	@Column(name = "fechaCreacion")
	BigInteger fechaCreacion;
	@Column(name = "fechaResolucion")
	BigInteger fechaResolucion;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public BigInteger getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(BigInteger fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public BigInteger getFechaResolucion() {
		return fechaResolucion;
	}
	public void setFechaResolucion(BigInteger fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

}