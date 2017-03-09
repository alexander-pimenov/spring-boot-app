package com.boot.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import com.boot.entity.Users;
import com.boot.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

	// An EntityManager will be automatically injected from entityManagerFactory
	// setup on DatabaseConfig class.
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Users user) {
		entityManager.persist(user);
	}

	public Users findByLoginAndPassword(String login, String password) {
		try {
			return (Users) entityManager.createQuery("from Users where login = :login and password = :password")
					.setParameter("login", login).setParameter("password", password).getSingleResult();
		} catch (NoResultException e) {
		}
		return null;

	}

	public Users findByLogin(String login) {
		try {
			return (Users) entityManager.createQuery("from Users where login = :login").setParameter("login", login)
					.getSingleResult();
		} catch (NoResultException e) {
		}
		return null;

	}

}
