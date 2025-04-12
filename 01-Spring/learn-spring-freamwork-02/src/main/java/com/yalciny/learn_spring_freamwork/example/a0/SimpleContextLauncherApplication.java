package com.yalciny.learn_spring_freamwork.example.a0;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ComponentScan parametre olmadan bulunduğu ve tüm alt paketleri arar 
@ComponentScan("com.yalciny.learn_spring_freamwork")
public class SimpleContextLauncherApplication {
	
	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(SimpleContextLauncherApplication.class))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
		
	}

}
