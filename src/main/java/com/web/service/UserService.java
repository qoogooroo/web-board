package com.web.service;

import java.util.List;
import java.util.Map;

import com.web.dto.UserDTO;
import com.web.repository.UserRepository;

public class UserService {
	
	private UserRepository userRepo = new UserRepository();

	public List<UserDTO> getUsers(Map<String,String> param){
		return userRepo.selectUsers(param);
	}
	
	public UserDTO getUser(int uiNum) {
		return userRepo.selectUser(uiNum);
	}
	
	public UserDTO login(String uiId, String uiPwd) {
		UserDTO user = userRepo.selectUserByUiId(uiId);
		if(user!=null && uiPwd.equals(user.getUiPwd())) { //uiId 가 DB상에 없다면 user==null
			return user;
		}
		return null;
	}
	
	public int addUser(UserDTO user) {
		if(userRepo.selectCntById(user)==1) {
			return -1;
		}
		return userRepo.insertUser(user);
	}
	
	public int modifyUser(UserDTO user) {
		return userRepo.updateUser(user);
	}
	
	public int removeUser(int uiNum) {
		return userRepo.deleteUser(uiNum);
	}
}
