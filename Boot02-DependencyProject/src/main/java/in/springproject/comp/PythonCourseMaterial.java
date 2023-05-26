package in.springproject.comp;

import org.springframework.stereotype.Component;

@Component(value="pythonobj")
public class PythonCourseMaterial implements ICourse {

	static
	{
		System.out.println("PythonCourseMaterial is loading...");
	}
	
	public PythonCourseMaterial() {
		System.out.println("PythonCourseMaterial:Zero Paramter");
	}
	
	@Override
	public String courseContent() {
		// TODO Auto-generated method stub
		return "1.Introduction 2.List,Tuple,Set,Directories 3.OOP";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 5000;
	}

}
