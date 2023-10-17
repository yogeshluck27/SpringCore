package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	//With @Bean annotation we are writting Bean Creation Logic
	//IF we use @Component on all games classes then Spring will manage instantiation of game
	@Bean
	public GamingConsole game() {
		PacmanGame game = new PacmanGame();
		return game;
	}

	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		GameRunner gameRunner = new GameRunner(game);
		return gameRunner;
	}

}
