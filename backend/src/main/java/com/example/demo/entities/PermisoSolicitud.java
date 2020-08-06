package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import java.math.BigInteger;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "permiso_solicitud")
public class PermisoSolicitud {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPermisoSolicitud")
	Long Id;
    @OneToOne
    @JoinColumn(name = "solicitud_idsolicitud", nullable=false, updatable=false)
    private Solicitud solicitud;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idpermiso", nullable=false, updatable=false)
    private Permiso permiso;
    @Column(name = "dateFrom")
    private BigInteger from;
    @Column(name = "dateTo")
    private BigInteger to;
    @Column(name = "idreemplazante")
    private int reemplazante;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Solicitud getSolicitud() {
		return solicitud;
	}
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	public Permiso getPermiso() {
		return permiso;
	}
	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
	public BigInteger getFrom() {
		return from;
	}
	public void setFrom(BigInteger from) {
		this.from = from;
	}
	public BigInteger getTo() {
		return to;
	}
	public void setTo(BigInteger to) {
		this.to = to;
	}
	public int getReemplazante() {
		return reemplazante;
	}
	public void setReemplazante(int reemplazante) {
		this.reemplazante = reemplazante;
	}
    

}
