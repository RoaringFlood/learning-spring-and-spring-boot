package com.yalciny.learn_spring_freamwork.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan parametre olmadan bulunduğu ve tüm alt paketleri arar 
@ComponentScan("com.yalciny.learn_spring_freamwork")
public class GaminAppLauncherApplication {
	
	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(GaminAppLauncherApplication.class))
		{
			//context.getBean(GamingConsole.class).up();
			context.getBean(GameRunner.class).run();
		}
		
	}

}
