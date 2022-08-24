package tutorials.springtesting.springtestingdemo.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import tutorials.springtesting.springtestingdemo.service.WelcomeService;

class WelcomeControllerUnitTest {

	@Test
	void shouldWelcome() {
		WelcomeService welcomeService = Mockito.mock(WelcomeService.class);
		Mockito.when(welcomeService.welcomeUser("Dev")).thenReturn("Welcome Dev!");
		WelcomeController controller = new WelcomeController(welcomeService);
		assertEquals("Welcome Dev!", controller.welcome("Dev"));
	}

}
