package com.example.demo.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado {
	@Id
	@Column(name = "iduser")
	private Long Id;
	@Column(name = "cargo")
	String cargo;
	@Column(name = "unidad")
	String unidad;
	@Column(name = "contratoType")
	String contratoType;
	@Column(name = "contratoIni")
	BigInteger contratoIni;
	@Column(name = "contratoFin")
	BigInteger contratoFin;
	@Column(name = "diasRestantes")
	int diasRestantes;
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public String getContratoType() {
		return contratoType;
	}
	public void setContratoType(String contratoType) {
		this.contratoType = contratoType;
	}
	public BigInteger getContratoIni() {
		return contratoIni;
	}
	public void setContratoIni(BigInteger contratoIni) {
		this.contratoIni = contratoIni;
	}
	public BigInteger getContratoFin() {
		return contratoFin;
	}
	public void setContratoFin(BigInteger contratoFin) {
		this.contratoFin = contratoFin;
	}
	public int getDiasRestantes() {
		return diasRestantes;
	}
	public void setDiasRestantes(int diasRestantes) {
		this.diasRestantes = diasRestantes;
	}
	
}
