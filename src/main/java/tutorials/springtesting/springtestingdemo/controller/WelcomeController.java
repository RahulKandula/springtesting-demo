package tutorials.springtesting.springtestingdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tutorials.springtesting.springtestingdemo.service.WelcomeService;

@RestController
public class WelcomeController {

	private final WelcomeService welcomeService;

	public WelcomeController(WelcomeService welcomeService) {
		this.welcomeService = welcomeService;
	}

	@GetMapping("/welcome")
	public String welcome(@RequestParam(defaultValue = "nobody") String user) {
		return welcomeService.welcomeUser(user);
	}

}
