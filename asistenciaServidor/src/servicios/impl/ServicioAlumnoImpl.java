package servicios.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g5.asistencia.persistencia.Alumno;

@Service
@Transactional
public class ServicioAlumnoImpl {

	
	
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		
	}
	public List<Alumno> listar(int idalumno) {
		StringBuilder sb = new StringBuilder();
		sb.append("select o");
		sb.append("from alumno");
		sb.append("order by o.apellido asc");
		TypedQuery<Alumno> qry = em.createNamedQuery(sb.toString(), Alumno.class);
		return qry.getResultList();

	}
}
