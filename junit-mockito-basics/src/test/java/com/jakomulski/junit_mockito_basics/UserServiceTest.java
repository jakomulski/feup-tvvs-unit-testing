package com.jakomulski.junit_mockito_basics;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.validateMockitoUsage;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class UserServiceTest {

	private UserService target;
	private UserDao userDaoMock = mock(UserDao.class);

	@BeforeEach
	public void setUp() {
		target = new UserService(userDaoMock);
	}

	@Test
	public void shouldReturnUserName() {
		when(userDaoMock.getUserFirstName()).thenReturn("John");
		when(userDaoMock.getUsetLastName()).thenReturn("Cena");
		
		assertThat(target.getName(), is(equalTo("John Cena")));
	}

	@Test
	public void shouldReturnUserAgeAsString() {
		when(userDaoMock.getUserAge()).thenReturn(40);
		assertThat(target.getAge(), is(equalTo("40")));

		verify(userDaoMock, times(1)).getUserAge();
	}

	@AfterEach
	public void tearDown() {
		validateMockitoUsage();
	}
}
