package com.yalciny.learn_spring_freamwork.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person (String name, int age, Address address) {}; //record sayesinde constructer, getter, setter yazmamıza gerek kalmaz

record Address (String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Yalçın";
	}
	
	@Bean
	public int age() {
		return 27;
	}
	
	@Bean
	public Person person() {
		var person = new Person("Ahmet", 20, new Address("Araç", "Kastamonu"));
		return person;
	}
	
	@Bean
	public Person person2MethodCall() {
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person person3Paramaters(String name, int age, Address adres2) {
		return new Person(name, age, adres2);
	}
	
	@Bean
	public Person person4Qualifier(String name, int age, @Qualifier("adres2qualifier") Address address) {
		return new Person(name, age, address);
	}
	
	@Bean(name = "adres")
	@Primary
	public Address address() {
		return new Address("Cihangir", "İstanbul");
	}
	@Bean(name = "adres2")
	@Qualifier("adres2qualifier")
	public Address address2() {
		return new Address("Merkez", "Karabük");
	}
}
