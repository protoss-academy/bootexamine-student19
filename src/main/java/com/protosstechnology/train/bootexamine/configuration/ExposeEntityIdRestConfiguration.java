package com.protosstechnology.train.bootexamine.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.protosstechnology.train.bootexamine.entity.Document;

@Configuration
public class ExposeEntityIdRestConfiguration extends RepositoryRestConfigurerAdapter{
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Document.class);
	}

}
