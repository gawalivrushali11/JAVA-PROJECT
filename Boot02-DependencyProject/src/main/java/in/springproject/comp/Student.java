package in.springproject.comp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component 
//@Component=detect this class during component scanning and 
//automatically create an instance of it with classname -student a bean in the Spring application context.

public class Student {
	

	//automatically wire dependencies between beans. 
	//It enables automatic injection of ICourse -all three obj -javaobj,pythonobj,sqlobj of ICourse type
	
	@Autowired(required=true) 
	
	//But at a time only one injection is allowed of same type either javaobj,pythonobj or sqlobj 
	//hence either use @Primary or @Qualifier to inject bean and avoid confusion
	
	@Qualifier("pythonobj")
	private ICourse course;
	
	static
	{
		System.out.println("Student is loading...");
	}
	
	public Student() {
		System.out.println("Student:Zero Paramter");
	}
	
	public void examPreparation(String examname)
	{
		System.out.println("Preparing for Exam");
		System.out.println("Course Choosen is::"+course.getClass().getName());
		System.out.println("Student is preparing for:"+examname);
		System.out.println(course.courseContent());
		System.out.println(course.price());
		System.out.println(examname+"Exam completed");
	}
	

}
