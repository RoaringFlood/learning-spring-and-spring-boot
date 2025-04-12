package com.yalciny.learn_spring_freamwork.helloworld;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {
		//1: Launch a Spring Context
		try(var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class))
		{
			//2: Configure the things that we want Spring to manage - @Configuration
			//HelloWorldConfiguration içinde @Configuration tanımladık
			// @Bean olarakta "name" class ını ekledik
			
			System.out.println(context.getBean("name"));
			System.out.printf("Age is %s\n",context.getBean("age"));
			
			System.out.println(context.getBean("person"));
			System.out.println(context.getBean("person2MethodCall"));
			System.out.println(context.getBean("person3Paramaters"));
			System.out.println(context.getBean("person4Qualifier"));
			
			System.out.println(context.getBean("adres"));
			System.out.println(context.getBean("adres2"));
			System.out.println(context.getBean(Address.class));
			
			//Springin kontrol ettiği tüm bean leri listeler
			//Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);	
		}
		
	}

}
