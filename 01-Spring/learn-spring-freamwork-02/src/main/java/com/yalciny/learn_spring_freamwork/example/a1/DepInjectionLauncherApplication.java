package com.yalciny.learn_spring_freamwork.example.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBusinessClass{ 
	//@Autowired // Dependency leri autowire layınca Field injection 
	Dependency1 dependency1;
	Dependency2 dependency2;

	//Önerilen injection tipi bu
	@Autowired //bu injectionda autowire yapmak zorunda değilsin
	public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor injection is working");
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}
	
//	@Autowired // Setter injection
//	public void setDependency1(Dependency1 dependency1) { // Setter injection
//		System.out.println("Setter injection is working");
//		this.dependency1 = dependency1;
//	}
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		this.dependency2 = dependency2;
//	}


	public String toString() { //toString metdo, main metodda sysout için çağırdığımızda çalışır
		return "Using " + dependency1 + " and " + dependency2;
	}
}

@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}

@Configuration
@ComponentScan //parametre olmadan bulunduğu ve tüm alt paketleri arar 
//@ComponentScan("com.yalciny.learn_spring_freamwork")
public class DepInjectionLauncherApplication {
	
	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(DepInjectionLauncherApplication.class))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(YourBusinessClass.class));
			System.out.println(context.getBean(YourBusinessClass.class).toString());
			System.out.println(context.getBean(YourBusinessClass.class).dependency1);
		
		}
		
	}

}
