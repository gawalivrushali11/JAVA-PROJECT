package in.springproject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.springproject.model.Employee;

@Repository("empDao")
public class EmployeeDaoImple implements IEmployee {

	@Autowired    //Hikari cp object automatically injected but for connection to database give username password in application.properties in <k,v> form 
	private DataSource datasource;
	
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	private static final String sql_select_query="select eid,ename,eaddress from employee";
	
	
	
	
	@Override
	public List<Employee> findAllEmployee()throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("DataSource name::"+datasource.getClass().getName());
		List<Employee> emplist=null;
		try(
				Connection conn=datasource.getConnection();
				PreparedStatement psmt=conn.prepareStatement(sql_select_query);
				ResultSet rs=psmt.executeQuery();)
		{
			
		   emplist=new ArrayList<Employee>();
			while(rs.next())
			{
				Employee e=new Employee();
				e.setEid(rs.getInt(1));
				e.setEname(rs.getString(2));
				e.setEaddress(rs.getString(3));
				emplist.add(e);
			}
			
			
		}
		return emplist;
	}//findAllEmployee

	public void setEmployee(Employee e)throws SQLException
	{
		final String sql_insert_query="insert into employee (eid,ename,eaddress) values(?,?,?)";
		Integer eid=e.getEid();
		String ename=e.getEname();
		String eaddress=e.getEaddress();
		try
		{
		jdbctemplate.update(sql_insert_query, eid,ename,eaddress);
		}
		catch(DataAccessException ex)
		{
			System.out.println(ex.getMessage());
		}
		
		
		
	}//setEmployee
	
	public void removeEmployee(int eid)throws SQLException
	{
		final String sql_delete_query="delete from employee where eid=?";
		
		try
		{
		int rowcount=jdbctemplate.update(sql_delete_query, eid);
		if(rowcount>=1)
			System.out.println("Employee deleteed");
		
		else
			System.out.println("Eid does not exist");
		}
		catch(DataAccessException ex)
		{
			System.out.println(ex.getMessage());
		}
		
	}//removeEmployee
	
	public void updateEmployee(int eid,String ename)throws SQLException
	{
		final String sql_update_query="update employee set ename=? where eid=?";
		
		try
		{
		int rowcount=jdbctemplate.update(sql_update_query,ename,eid);
		if(rowcount>=1)
			System.out.println("Employee details updated");
		
		else
			System.out.println("Eid does not exist");
		}
		catch(DataAccessException ex)
		{
			System.out.println(ex.getMessage());
		}
	}
}
