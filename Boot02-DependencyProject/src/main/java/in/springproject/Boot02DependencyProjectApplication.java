package in.springproject;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.springproject.comp.Student;

@SpringBootApplication
public class Boot02DependencyProjectApplication {

	public static void main(String[] args) {
		
		//Create and load container
		ApplicationContext contextApp=SpringApplication.run(Boot02DependencyProjectApplication.class, args);
		
		System.out.println("No.of beans::"+Arrays.toString(contextApp.getBeanDefinitionNames()));
		//Multiple beans are available but wants to start with student
		Student student=contextApp.getBean("student",Student.class);
		System.out.println(student);
		student.examPreparation("Java");	
		}

}
