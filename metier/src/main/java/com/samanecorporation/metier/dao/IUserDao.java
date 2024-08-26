package com.samanecorporation.metier.dao;

import java.util.Optional;

import com.samanecorporation.metier.entity.UserEntity;

public interface IUserDao extends Repository<UserEntity> {

	public Optional<UserEntity> login (String email, String password);
}
