package com.misys.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.misys.dao.UserDAO;
import com.misys.domain.entity.UserMaster;
import com.misys.exception.DAOException;
import com.misys.exception.DBRecordNotFoundException;
import com.misys.exception.UserServiceException;

@Service("userService")
@Repository
public class UserService {

	@Inject
	private UserDAO userDAO;
	@Transactional(rollbackFor = DAOException.class)
	public void saveUser(UserMaster userMaster) throws UserServiceException {
		try {
			userDAO.persist(userMaster);
		} catch (DAOException e) {
			throw new UserServiceException(e);
		}
	}

	@Transactional(rollbackFor = DAOException.class)
	public void updateUser(UserMaster userMaster) throws UserServiceException {
		try {
			userDAO.update(userMaster);
		} catch (DAOException e) {
			throw new UserServiceException(e);
		}
	}

	public UserMaster findById(Long userId) throws UserServiceException {
		try {
			return userDAO.findById(UserMaster.class, userId);
		} catch (DAOException e) {
			throw new UserServiceException(e);
		}
	}

	public List<UserMaster> findAll() throws UserServiceException {
		try {
			return userDAO.findAll(UserMaster.class);
		} catch (DAOException e) {
			throw new UserServiceException(e);
		}
	}


	public UserMaster findByEmail(String email) throws UserServiceException {
		try {
			return userDAO.findByEmail(email);
		} catch (DBRecordNotFoundException e) {
			throw new UserServiceException(e);
		}
	}

	/**
	 * Get logged in user
	 * 
	 * @return
	 * @throws EmailNotFoundException
	 */
/*	public UserMaster getLoggedInUser() throws EmailNotFoundException {
		String email = SecurityContextHolder.getContext().getAuthentication()
				.getName();
		// Retrieve user from database
		UserMaster user = findByEmail(email);
		return user;
	}

	public LoginResponse getLoggedInUserResponse() {
		try {
			UserMaster user = getLoggedInUser();
			LoginResponse loginResponse = new LoginResponse();
			loginResponse.setEmail(user.getEmail());
			return loginResponse;
		} catch (EmailNotFoundException e) {
			return null;
		}
	}*/
}
