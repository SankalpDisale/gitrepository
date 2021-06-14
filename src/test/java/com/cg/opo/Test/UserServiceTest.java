package com.cg.opo.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.opo.dao.UserJPARepository;
import com.cg.opo.model.Customer;
import com.cg.opo.model.User;
import com.cg.opo.serviceImpl.UserServiceImpl;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest 
{

	@Autowired
    private UserServiceImpl userservice;

    @MockBean
    private UserJPARepository dao;

  
   @Test
    public void deleteUserById(){
    	
    	User user = new User();

    	user.setUserId(45);
    	user.setUserName("sds");
    	user.setPass("df");
    	user.setCustomer(null);
    	
    	Mockito.when(dao.findById(45)).thenReturn(user);

    	userservice.deleteUser(user.getUserId());
        verify(dao, times(1)).deleteById(user.getUserId());
    }
   

    
    @Test
    public void getAllUsersTest(){

    	User user = new User();

    	user.setUserId(12);
    	user.setUserName("Admin");
    	user.setPass("1234ad");
    	


    	User user1 = new User();

    	user1.setUserId(12);
    	user1.setUserName("Admin");
    	user1.setPass("1234ad");
    	
    	

        List<User> uList = new ArrayList<>();
        uList.add(user);
        uList.add(user1);

        Mockito.when(dao.findAll()).thenReturn(uList);

        assertThat(userservice.getAllUsers()).isEqualTo(uList);
    }
    
    
   @Test
    public void findByIdTest() {

    User u = new User(1,"sans","pass",null);
    Mockito.when(dao.findById(1)).thenReturn(u);
    userservice.findUserById(1);
    assertEquals(u,userservice.findUserById(1));
    
    }
   
   @Test
   public void findByNameTest() {
	   
	   User u = new User(1,"Rishabh","pass",null);
	   List<User> list = new ArrayList<>();
	   Mockito.when(dao.findByName("Rishabh")).thenReturn(list);
	   userservice.findUserByName("Rishabh");
	   assertEquals(list,userservice.findUserByName("Rishabh"));
	   
   }
   
   /////////////////// NOT DONE
   
   /*  @Test
   public void updateUserTest()
   {

   	User user = new User();


   	user.setUserId(45);
   	user.setUserName("sds");
   	user.setPass("df");
   	user.setCustomer(null);
   	
       Mockito.when(dao.save(user)).thenReturn(user);
       assertThat(userservice.updateUser(user)).isEqualTo(user);
   }
   */
}
