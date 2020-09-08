package com.protosstechnology.train.bootexamine;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class BootexamineApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private WebApplicationContext wac;
	@Autowired
	private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception {}
	@After
	public void tearDown() throws Exception {}
	
	@Test
	public void addUser_thenOk() throws Exception {
		mockMvc.perform(post("/document").content("{ \"documentNumber\": \"Doc-001\", \"description\": \"Credential Document\" }")
				.contentType("application/json"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void editUser_thenOk() throws Exception {
		addUser_thenOk();
		mockMvc.perform(put("/document/1").content("{ \"documentNumber\": \"Doc-001\", \"description\": \"Credential Document. Do not disclose!\" }")
				.contentType("application/json"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void deleteUser_thenOk() throws Exception {
		addUser_thenOk();
		mockMvc.perform(delete("/document/1")).andExpect(status().isOk());
	}

}
