package com.g5.asistencia.servicios;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g5.asistencia.persistencia.Asistencia;
@Service
@Transactional
public class ServiciosAsistencias {
	@PersistenceContext
	private EntityManager em;
	
	@PostConstruct
	public void init() {
		
	}
	
	
		public List<Asistencia> listar(int idasistencia) {
			StringBuilder sb = new StringBuilder();
			sb.append("select o");
			sb.append("from asistencia");
			sb.append("order by o.idalumno asc");
			TypedQuery<Asistencia> qry = em.createNamedQuery(sb.toString(), Asistencia.class);
			return qry.getResultList();

		}
}
