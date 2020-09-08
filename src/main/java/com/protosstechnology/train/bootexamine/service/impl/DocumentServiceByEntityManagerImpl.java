package com.protosstechnology.train.bootexamine.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.protosstechnology.train.bootexamine.entity.Document;
import com.protosstechnology.train.bootexamine.service.JServices;


@Service
@Transactional
public class DocumentServiceByEntityManagerImpl implements JServices{
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Document document) {
		entityManager.persist(document);
		entityManager.flush();
	}
	
	@Override
	public Document read(Long id) { return entityManager.find(Document.class, id); }
	
	@Override
	public Document update(Document document) { return entityManager.merge(document); }
	
	@Override
	public void delete(Long id) { entityManager.remove(entityManager.find(Document.class, id)); }

}
