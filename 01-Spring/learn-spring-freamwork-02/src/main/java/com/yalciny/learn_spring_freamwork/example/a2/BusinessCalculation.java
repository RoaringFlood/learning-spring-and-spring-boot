package com.yalciny.learn_spring_freamwork.example.a2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


//@Component
@Repository
@Qualifier
class MySQLDataService implements DataService {
	
	public int[] retrieveData() {
		return new int[] {1,2,3,4,5};
	}
}

//@Component
@Repository
@Primary
class MongoDbDataService implements DataService {
	
	public int[] retrieveData() {
		return new int[] {11,22,33,44,55};
	}
}

//@Component
@Service
class BusinessCalculationService{
	//@Autowired bu şekilde kullanırsak field injection olurdu
	DataService dataService;
	
	@Autowired //constructor için kullanmasakta olur (constructor injection)
	public BusinessCalculationService(@Qualifier("mySQLDataService") DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
}

@Configuration
@ComponentScan
public class BusinessCalculation {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(BusinessCalculation.class))
		{
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println(context.getBean(BusinessCalculationService.class));
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}

}
