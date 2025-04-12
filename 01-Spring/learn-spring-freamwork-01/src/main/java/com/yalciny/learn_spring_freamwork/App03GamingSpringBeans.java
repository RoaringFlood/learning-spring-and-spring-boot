package com.yalciny.learn_spring_freamwork;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yalciny.learn_spring_freamwork.game.GameRunner;
import com.yalciny.learn_spring_freamwork.game.GamingConsole;
import com.yalciny.learn_spring_freamwork.game.MarioGame;
import com.yalciny.learn_spring_freamwork.game.PacmanGame;
import com.yalciny.learn_spring_freamwork.game.SuperContraGame;

public class App03GamingSpringBeans {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class))
		{
			context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
		//var game = new MarioGame();
		//var game = new SuperContraGame();
		//var game = new PacmanGame();
		//var gameRunner = new GameRunner(game);
		//GameRunner gameRunner = new GameRunner(marioGame); // var veya class adı direk tanımlamada kullanılır. var işimizi kolaylaştırıyor
		//gameRunner.run();
		//System.out.println("Running game: " + marioGame); //classtan oluşturduğumuz obje
		//marioGame.down();
	}

}
