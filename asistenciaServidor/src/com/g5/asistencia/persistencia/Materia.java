package com.g5.asistencia.persistencia;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the materia database table.
 * 
 */
@Entity
@NamedQuery(name="Materia.findAll", query="SELECT m FROM Materia m")
public class Materia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private String materia;

	private Integer totalasistencia;

	//bi-directional many-to-one association to Alumno
	@OneToMany(mappedBy="materia")
	private List<Alumno> alumnos;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	@JoinColumn(name="iddocente")
	private Docente docente;

	public Materia() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMateria() {
		return this.materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public Integer getTotalasistencia() {
		return this.totalasistencia;
	}

	public void setTotalasistencia(Integer totalasistencia) {
		this.totalasistencia = totalasistencia;
	}

	public List<Alumno> getAlumnos() {
		return this.alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno addAlumno(Alumno alumno) {
		getAlumnos().add(alumno);
		alumno.setMateria(this);

		return alumno;
	}

	public Alumno removeAlumno(Alumno alumno) {
		getAlumnos().remove(alumno);
		alumno.setMateria(null);

		return alumno;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

}