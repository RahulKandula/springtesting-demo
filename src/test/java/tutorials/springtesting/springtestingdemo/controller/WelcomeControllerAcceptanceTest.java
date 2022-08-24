package tutorials.springtesting.springtestingdemo.controller;

import static org.mockito.Mockito.verify;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class WelcomeControllerAcceptanceTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	void shouldDisplayDefaultWelcomeMessage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Welcome nobody!")));
	}

	@Test
	void shouldDisplayCustomWelcomeMessage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/welcome?user=victoria"))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Welcome victoria!")));
	}

}
