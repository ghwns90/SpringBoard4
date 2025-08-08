package com.board.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.users.domain.UserDTO;
import com.board.users.mapper.UserMapper;

@Controller
@RequestMapping("/Users")
public class UserController {
	
	@Autowired
	private  UserMapper  userMapper;
	
	// /Users/List
	@RequestMapping("/List")
	public  String  list( Model   model ) {
		
		List<UserDTO> userList =  userMapper.getUserList();
		System.out.println( "1:userList:" + userList );
				
		model.addAttribute("userList", userList);
		
		return "users/list";
	}

	// /Users/WriteForm
	@RequestMapping("/WriteForm")
	public  String  writerForm() {		
		return "users/write";
	}
	
	// /Users/Write
	@RequestMapping("/Write")
	public  String  write( UserDTO userDTO ) {
		
		System.out.println("2:" +  userDTO );
		
		userMapper.insertUser( userDTO );
		
		return "redirect:/Users/List";
	}
	
	// http://localhost:9090/Users/Delete?userid=sky
	@RequestMapping("/Delete")
	public  String   delete( UserDTO  userDTO  ) {
		
		System.out.println( userDTO );
		
		userMapper.deleteUser( userDTO );
		
		return "redirect:/Users/List";
	}
	
	@RequestMapping("/UpdateForm")
	public String updateForm( UserDTO userDTO, Model model){				
		
		UserDTO user = userMapper.getUser( userDTO );
		
		model.addAttribute( "user", user);
		System.out.println("updateform : " + userDTO);
		
		return "users/update";
	}
	
	@RequestMapping("/Update")
	public String update(UserDTO userDTO) {
		
		userMapper.update( userDTO );
		System.out.println(userDTO);
		return "redirect:/Users/List";
	}
	
}



















