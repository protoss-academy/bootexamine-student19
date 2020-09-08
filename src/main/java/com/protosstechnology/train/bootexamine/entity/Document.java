package com.protosstechnology.train.bootexamine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of= {"id"})
public class Document {
	
	private @Id @GeneratedValue Long id;
	
	@NonNull private String documentNumber;
	@NonNull private String description;

}
