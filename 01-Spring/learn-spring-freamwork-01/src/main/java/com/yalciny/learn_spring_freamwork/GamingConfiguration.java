package com.yalciny.learn_spring_freamwork;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.yalciny.learn_spring_freamwork.game.GameRunner;
import com.yalciny.learn_spring_freamwork.game.GamingConsole;
import com.yalciny.learn_spring_freamwork.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	
	@Bean
	@Primary
	public GamingConsole game() {
		return new PacmanGame();
	}
	
	@Bean
	@Primary
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}
	
	//var game = new MarioGame();
	//var game = new SuperContraGame();
	
//	var gameRunner = new GameRunner(game);
//	//GameRunner gameRunner = new GameRunner(marioGame); // var veya class adı direk tanımlamada kullanılır. var işimizi kolaylaştırıyor
//	gameRunner.run();
//	//System.out.println("Running game: " + marioGame); //classtan oluşturduğumuz obje
//	//marioGame.down();
}
