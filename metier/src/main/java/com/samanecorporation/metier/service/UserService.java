package com.samanecorporation.metier.service;

import java.util.List;
import java.util.Optional;

import com.samanecorporation.metier.dao.IUserDao;
import com.samanecorporation.metier.dao.UserDao;
import com.samanecorporation.metier.dto.UserDto;
import com.samanecorporation.metier.entity.UserEntity;
import com.samanecorporation.metier.mapper.UserMapper;

import javax.transaction.Transactional;

public class UserService implements IUserService {

	private final IUserDao userDao = new UserDao();
	
	@Override
	public List<UserDto> getAll() {
	
		return UserMapper.listUserEntityToListUserDto(userDao.list(new UserEntity()));
	}

	@Override
	public UserDto get(int id) {
		return UserMapper.toUserDto(userDao.get(id, new UserEntity()));
	}

	@Override
	public boolean delete(int id) {
		return userDao.delete(id, new UserEntity());
	}

	@Override
	public boolean save(UserDto userDto) {
		
		return userDao.save(UserMapper.toUserEtity(userDto));
	}

	@Override
	public boolean update(UserDto userDto) {
		return userDao.update(UserMapper.toUserEtity(userDto));
	}

	@Override
	public Optional<UserDto> login(String email, String password) {
		Optional<UserEntity> userEntity = userDao.login(email, password);
		
		if (userEntity.isPresent()) {
			UserEntity user = userEntity.get();
			return Optional.of(UserMapper.toUserDto(user));
		} else {
			return Optional.empty();
		}
	}

}
