package com.protosstechnology.train.bootexamine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.protosstechnology.train.bootexamine.entity.Document;
import com.protosstechnology.train.bootexamine.service.JServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/document")
public class jController {
	
	@Autowired
	JServices jService;
	
	
	@Operation(summary = "Get Document by id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the document",
					content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Document.class))}),
			@ApiResponse(responseCode = "400", description = "Invalid id document", content = @Content),
			@ApiResponse(responseCode = "404", description = "Document Not Found", content = @Content)
	})
	@GetMapping("/{id}")
	public ResponseEntity<Document> getDocument(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(jService.read(Long.parseLong(id)));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Document> updateDocument(@PathVariable("id") String id,
											@RequestBody Document document) {
		document.setId(Long.parseLong(id));
		return ResponseEntity.ok().body(jService.update(document));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDocument(@PathVariable("id") String id) {
		String responseStr = new String();
		try {
			jService.delete(Long.parseLong(id));
			responseStr = "Delete Document id: "+id+" successfully";
		} catch(Exception e) {
			responseStr = "Delete Document id: "+id+" failed";
		}
		return ResponseEntity.ok().body(responseStr);
	}
	
	@PostMapping
	public ResponseEntity<Document> addDocument(@RequestBody Document document) {
		log.info("in addDocument");
		jService.create(document);
		
		log.info("Document id: {}", document.getId());
		return ResponseEntity.ok().body(document);
	}
	
	
}
