package com.yalciny.learn_spring_freamwork.example.b1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Component
@Lazy // Spring_context i oluşturduğumuz anda çalışmaması, sadece bean i kullandığımızda initialize etmesi için
	  // ClassB kullanılmadığı, çağırılmadığı sürece initialize etmesini engeller
class ClassB {

	ClassA classA;
	
	public ClassB(ClassA classA) {
		//Logic
		System.out.println("Some Initialization logic"); //1. çalışma sırası
		this.classA = classA;
	}
	
	public void doSomeThing() {
		System.out.println("Doing something."); //2. çalışma sırası
	}
	
}

@Configuration
@ComponentScan//parametre olmadan bulunduğu ve tüm alt paketleri arar 
//@ComponentScan("com.yalciny.learn_spring_freamwork")
public class LazyInitializationLauncherApplication {
	
	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println("Initialization of context is completed");
			context.getBean(ClassB.class).doSomeThing();
		}
		
	}

}
