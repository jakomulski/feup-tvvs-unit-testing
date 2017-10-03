package com.jakomulski.junit_mockito_basics;

public class UserService {

	public UserService(UserDao testDao) {
		this.testDao = testDao;
	}

	private final UserDao testDao;

	public String getName() {
		return testDao.getUserFirstName() + " " + testDao.getUsetLastName();
	}

	public String getAge() {
		return Integer.toString(testDao.getUserAge());
	}
}
