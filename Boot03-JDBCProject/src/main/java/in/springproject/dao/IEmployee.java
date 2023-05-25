package in.springproject.dao;

import java.sql.SQLException;
import java.util.List;

import in.springproject.model.Employee;

public interface IEmployee {
	public List<Employee> findAllEmployee()throws SQLException;
	public void setEmployee(Employee e)throws SQLException;
	public void removeEmployee(int eid)throws SQLException;
	public void updateEmployee(int eid,String ename)throws SQLException;

}
