package com.protosstechnology.train.bootexamine.service;

import com.protosstechnology.train.bootexamine.entity.Document;

public interface JServices {
	public void create(Document document);
	public Document read(Long id);
	public Document update(Document user);
	public void delete(Long id);
}
