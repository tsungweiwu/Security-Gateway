package com.example.securegateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@SpringBootTest
@AutoConfigureMockMvc
class SecureGatewayApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	@WithMockUser(value = "user")
	@Test
	void givenAuthRequestOnPrivateService_shouldSucceedWith200() throws Exception {
		this.mockMvc.perform(get("/message")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	void notGivenAuthRequestOnPrivateService_shouldFailWith400() throws Exception {
		this.mockMvc.perform(get("/message")).andDo(print()).andExpect(status().isUnauthorized());
	}
}
