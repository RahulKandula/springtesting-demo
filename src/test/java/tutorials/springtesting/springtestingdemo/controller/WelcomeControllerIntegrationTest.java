package tutorials.springtesting.springtestingdemo.controller;

import static org.mockito.Mockito.verify;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import tutorials.springtesting.springtestingdemo.service.WelcomeService;

@WebMvcTest(controllers = WelcomeController.class)
class WelcomeControllerIntegrationTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	WelcomeService welcomeservice;

	@Test
	void shouldDisplayDefaultWelcomeMessage() throws Exception {
		Mockito.when(welcomeservice.welcomeUser("nobody")).thenReturn("Welcome nobody!");
		mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Welcome nobody!")));
		verify(welcomeservice).welcomeUser("nobody");
	}

	@Test
	void shouldDisplayCustomWelcomeMessage() throws Exception {
		Mockito.when(welcomeservice.welcomeUser("victoria")).thenReturn("Welcome victoria!");
		mockMvc.perform(MockMvcRequestBuilders.get("/welcome?user=victoria"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Welcome victoria!")));
		verify(welcomeservice).welcomeUser("victoria");
	}
	

}
