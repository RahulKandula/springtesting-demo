package tutorials.springtesting.springtestingdemo.service;

import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	
	public String welcomeUser(String user) {
		return String.format("Welcome %s!", user);
	}

}
