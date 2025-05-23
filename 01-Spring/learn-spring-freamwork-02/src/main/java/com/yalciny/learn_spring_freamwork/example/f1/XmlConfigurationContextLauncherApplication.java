package com.yalciny.learn_spring_freamwork.example.f1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yalciny.learn_spring_freamwork.game.MarioGame;


public class XmlConfigurationContextLauncherApplication {
	
	public static void main(String[] args) {

		try(var context = new ClassPathXmlApplicationContext("contextConfiguration.xml"))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			
			context.getBean(MarioGame.class).up();
		}
		
	}

}
