package com.samanecorporation.soap.webservice.service;

import java.util.List;

import com.samanecorporation.metier.dto.UserDto;
import com.samanecorporation.metier.service.IUserService;
import com.samanecorporation.metier.service.UserService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService
public class UserWebServiceImpl implements UserWebService {

	private final IUserService userService = new UserService();

	@Override
	@WebMethod(operationName = "getProduct")
	public UserDto get(@WebParam(name = "idUser") int id) {
		
		return userService.get(id);
	}

	@Override
	@WebMethod(operationName = "allUsers")
	public List<UserDto> all() {
		
		return userService.getAll();
	}

	@Override
	@WebMethod(operationName = "saveUser")
	public UserDto save(@WebParam(name = "user") UserDto userDto) {

		return userService.save(userDto)? userDto: null;
	}

}
