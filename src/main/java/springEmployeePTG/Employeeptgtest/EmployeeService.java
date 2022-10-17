package springEmployeePTG.Employeeptgtest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
	@Autowired
	MyRepo repo;
	public List<Employee> displayEmployee()
	{
		return repo.findAll();
	}
	public void addEmployee(Employee employee)
	{
		repo.save(employee);
	}
	public Employee updateEmploye(long id)
	{
		return repo.findById(id).get();
	}
	public void  deleteEmployee(long id) 
	{
		repo.deleteById(id);
	}
}
