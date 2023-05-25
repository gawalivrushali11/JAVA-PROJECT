package in.springproject;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import in.springproject.dao.EmployeeDaoImple;
import in.springproject.model.Employee;

@SpringBootApplication
public class Boot03JdbcProjectApplication {

	public static void main(String[] args) {
		ApplicationContext contextApp=SpringApplication.run(Boot03JdbcProjectApplication.class, args);
		Employee e=new Employee();
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter eid:");
			e.setEid(sc.nextInt());
			
			System.out.println("Enter ename:");
			e.setEname(sc.next());
			
			System.out.println("Enter eaddress:");
			e.setEaddress(sc.next());
			
			
			
			EmployeeDaoImple dao;
			try {
				
				dao = contextApp.getBean(EmployeeDaoImple.class);
				dao.setEmployee(e);  //Insert
				
				List<Employee> emps=dao.findAllEmployee(); //select
				emps.forEach(System.out::println);
				
				System.out.println("Enter eid to remove:");
				int eid=sc.nextInt();
				dao.removeEmployee(eid);
				
				System.out.println("Enter eid to update:");
				eid=sc.nextInt();
				System.out.println("Enter new emp name:");
				String ename=sc.next();
				dao.updateEmployee(eid, ename);
				
			} catch (BeansException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
	}

}
