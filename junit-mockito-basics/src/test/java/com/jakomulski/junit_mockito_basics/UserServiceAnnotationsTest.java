package com.jakomulski.junit_mockito_basics;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceAnnotationsTest {

	@Mock
	private UserDao userDaoMock;
	@InjectMocks
	private UserService target;
	
	@Test
	public void shouldReturnUserName() {
		when(userDaoMock.getUserFirstName()).thenReturn("John");
		when(userDaoMock.getUsetLastName()).thenReturn("Cena");

		assertEquals(target.getName(), "John Cena");
	}
}
