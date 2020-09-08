package com.protosstechnology.train.bootexamine.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.protosstechnology.train.bootexamine.entity.Document;
import com.protosstechnology.train.bootexamine.service.JServices;


public class jServiceImpl implements JServices{
	@Override
	public void create(Document document) {
		RestTemplate restTemplate = new RestTemplate();
		Document dataCreated = restTemplate.postForObject("http://139.5.146.3:8888/bootexamine-19/document/"+document.getId(), document, Document.class);
	}
	
	@Override
	public Document read(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getForObject("http://139.5.146.3:8888/bootexamine-19/document/"+id, Document.class);
		return null;
	}
	
	@Override
	public Document update(Document document) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://139.5.146.3:8888/bootexamine-19/document/"+document.getId(), document);
		return null;
	}
	
	@Override
	public void delete(Long id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://139.5.146.3:8888/bootexamine-19/document/"+id);
	}

}
