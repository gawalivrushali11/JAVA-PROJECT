package in.springproject.comp;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Lazy ==the javaobj bean will not be instantiated immediately. Instead, 
//it will be created and initialized only when it is requested by another bean(student)
//or component.
//by default all the beans are instantiated by IOC container

@Lazy

//@Component===detect this class during component scanning and 
//automatically create an instance of it as "javaobj" a bean in the Spring application context.

@Component(value="javaobj")
public class JavaCourseMaterial implements ICourse {
	
	static
	{
		System.out.println("JavaCourseMaterial is loading...");
	}
	
	public JavaCourseMaterial() {
		System.out.println("JavaCourseMaterial:Zero Paramter");
	}
	

	@Override
	public String courseContent() {
		// TODO Auto-generated method stub
		return "1.OOP 2.Exception Handling 3.Collection Framework";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 4000;
	}

}
