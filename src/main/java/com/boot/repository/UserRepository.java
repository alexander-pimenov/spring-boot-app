package com.boot.repository;

import com.boot.entity.Users;

/**
 * Repository for user object
 * 
 * @author admin
 *
 */
public interface UserRepository {

	/**
	 * Saves user in database
	 * 
	 * @param user
	 */
	void save(Users user);

	/**
	 * Get user from database by login and password
	 * 
	 * @param login
	 * @param password
	 * @return found user
	 */
	Users findByLoginAndPassword(String login, String password);

	/**
	 * Finds user by login
	 * 
	 * @param login
	 * @return user object
	 */
	Users findByLogin(String login);
}
