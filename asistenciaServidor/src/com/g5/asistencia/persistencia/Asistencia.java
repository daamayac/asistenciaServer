package com.g5.asistencia.persistencia;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer idasistencia;

	private Boolean asistencia;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	//bi-directional many-to-one association to Alumno
	@ManyToOne
	@JoinColumn(name="id_alumno")
	private Alumno alumno;

	public Asistencia() {
	}

	public Integer getIdasistencia() {
		return this.idasistencia;
	}

	public void setIdasistencia(Integer idasistencia) {
		this.idasistencia = idasistencia;
	}

	public Boolean getAsistencia() {
		return this.asistencia;
	}

	public void setAsistencia(Boolean asistencia) {
		this.asistencia = asistencia;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}