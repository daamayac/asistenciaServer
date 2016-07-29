package com.g5.asistencia.servicios;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.g5.asistencia.persistencia.Docente;

@Service
@Transactional
public class RestTest {

	@PersistenceContext private EntityManager em;
	
	@PostConstruct
	public void init(){
		Docente d=em.find(Docente.class,1);
		System.out.println(d.getApellido());
		
	}
	
	
}
