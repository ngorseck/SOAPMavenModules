package com.samanecorporation.metier.service;

import java.util.List;
import java.util.Optional;

import com.samanecorporation.metier.dto.UserDto;

public interface IUserService {

	public List<UserDto> getAll();
	public UserDto get(int id);
	public boolean delete(int id);
	public boolean save(UserDto userDto);
	public boolean update(UserDto userDto);
	public Optional<UserDto> login (String email, String password);
}
