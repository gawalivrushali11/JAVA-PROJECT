package in.springproject.comp;

import org.springframework.stereotype.Component;

@Component(value="sqlobj")
public class SqlCourseMaterial implements ICourse {
	
	static
	{
		System.out.println("SqlCourseMaterial is loading...");
	}
	
	public SqlCourseMaterial() {
		System.out.println("SqlCourseMaterial:Zero Paramter");
	}

	@Override
	public String courseContent() {
		// TODO Auto-generated method stub
		return "1.DDL 2.DML 3.DCL 4.Advance SQL";
	}

	@Override
	public float price() {
		// TODO Auto-generated method stub
		return 3000;
	}

}
