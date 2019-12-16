package com.cognizant.productservice.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import com.project.productservice.controller.UserController;
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerMockMvcTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	UserController userController;
	
	@Test
	public void getAllPendingAdminList() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/smartmart/admins")).andExpect(status().isOk());
	}
	@Test
	public void getUserByContactNumber() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/smartmart/users-contact/7356490987")).andExpect(status().isOk());
	}
	
	@Test
	public void getAllUsersForBilling() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/smartmart/user")).andExpect(status().isOk());
	}
	@Test
	public void getUserByUserID() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/smartmart/users/user-id/1")).andExpect(status().isOk());
	}
}
