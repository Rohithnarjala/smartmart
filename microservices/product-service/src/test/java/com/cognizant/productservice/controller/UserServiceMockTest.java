package com.cognizant.productservice.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.productservice.model.Users;
import com.project.productservice.repository.UserRepository;
import com.project.productservice.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceMockTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceMockTest.class);
	UserRepository repository = Mockito.mock(UserRepository.class);
	UserServiceImpl service = new UserServiceImpl(repository);
	
	@Test
	public void MockTestgetAllPendingAdminList() {
		when(repository.getAllPendingAdminList()).thenReturn(CreateUser1());
//		return repository.getAllPendingAdminList();
		List<Users> userList = service.getAllPendingAdminList();
		boolean flag = false;
		for(Users item:userList) {
			Users user = item;
			String expected ="P";
			assertEquals(expected, user.getStatus());
			
		}
		
	}
	public List<Users> CreateUser2() {
		List<Users> userList =new ArrayList<Users>();
//		Users user1 = new Users(5,"bb","bb",21,"Male",123412,"bb","$2a$10$RFvWWWrAdwVjR0G5GncqAedE/bnuhokD7096wepfB3jXlEICCA.Bm","A","P","what is your Nick name","bb","what is your favorite food","bb","what is your favorite holiday spot","bb");
//		Users user2 = new Users(2,"admin","admin",21,"Male",735,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","O","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa");
		Users user3 =new Users(1,"rohith","narjala",21,"Male",123412,"rohith","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","U","0","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa");
//		userList.add(user1);
//		userList.add(user2);
		userList.add(user3);
		return userList ;
		

	}
	public List<Users> CreateUser1() { 
		List<Users> userList =new ArrayList<Users>();
		Users user1 = new Users(5,"bb","bb",21,"Male",123412,"bb","$2a$10$RFvWWWrAdwVjR0G5GncqAedE/bnuhokD7096wepfB3jXlEICCA.Bm","A","0","P","what is your Nick name","bb","what is your favorite food","bb","what is your favorite holiday spot","bb");
//		Users user2 = new Users(2,"admin","admin",21,"Male",735,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","O","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa");
//		Users user3 =new Users(1,"rohith","narjala",21,"Male",123412,"rohith","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","U","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa");
		userList.add(user1);
//		userList.add(user2);
//		userList.add(user3);
		return userList;
		

	}
	
	public Users CreateUser() {
		Users user2 = new Users(2,"admin","admin",21,"Male",735,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","O","0","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa");	
		return user2;
	}
	public Users CreateUser3() {
		Users user3 = new Users(2,"admin","admin",21,"Male",7356490987L,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","O","0","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa");	
		return user3;
	}
	public Users CreateUser4() {
		Users user4 = new Users(2,"admin","admin",21,"Male",7356490987L,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","O","0","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa");	
		return user4;
	}
	public Users CreateUser5() {
		Users user5 = new Users(2,"admin","admin",21,"Male",7356490987L,"admin","$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS","O","0","A","what is your Nick name","aa","what is your favorite food","aa","what is your favorite holiday spot","aa");	
		return user5;
	}
	@Test
	public void MockTestmodifyApproval() {
//		when(repository.getAllPendingAdminList()).thenReturn(CreateUser1());
//		ret urn repository.getAllPendingAdminList();
//		Users user = service.modifyApproval(CreateUser());
		
//			String expected ="A";
//			assertEquals(expected, user.getStatus());
			
			
			when(repository.findByUserId("admin")).thenReturn(null);
			
			service.modifyApproval(CreateUser());
		}
	
//	
	@Test
	public void MockTestgetAllUsersForBilling() {
		when(repository.getAllUsersforbilling()).thenReturn(CreateUser2());
	List<Users> userList = service.getAllUsersForBilling();
	for(Users item:userList) {
		Users user = item;
		String expected ="U";
		assertEquals(expected, user.getUserType());
	}
		
	
	}
	@Test
	public void MockTestgetUserByUserID() {
		when(repository.findByUserId("admin")).thenReturn(CreateUser3());
		Users userList = service.getUserByUserId("admin");
			String expected ="admin"; 
			assertEquals(expected, userList.getUserId());
	}
	
	@Test
	public void MockTestgetUserByContactNumber() {
		when(repository.findByContactNumber(7356490987L)).thenReturn(CreateUser4());
		Users userList = service.getUserByContactNumber(7356490987L);
			long expected =7356490987L; 
			assertEquals(expected, userList.getContactNumber());
	}
	
	@Test 
	public void MockTestupdateUser() {
		service.updateUser(CreateUser5());
	}
} 
