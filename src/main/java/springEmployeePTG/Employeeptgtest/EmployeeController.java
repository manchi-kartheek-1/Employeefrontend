package springEmployeePTG.Employeeptgtest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController
{
	@Autowired
	EmployeeService service;
	@RequestMapping("/")
	public String displayEmp(Model model)
	{
		List<Employee> list = service.displayEmployee();
		for (Employee employee : list) 
		{
			System.out.println(employee.getName());
		}
		model.addAttribute("data", list);
		return "show";
	}
	@RequestMapping("/addData")
	public String empData(Model model)
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "add_emp";
	}
	@RequestMapping(value = "/save")
	public String saveData(@ModelAttribute("employee") Employee employee)
	{
		service.addEmployee(employee);
		return "redirect:/";
	}
	@RequestMapping("/edit/{id}")
	public ModelAndView updateEmp(@PathVariable(name = "id") int id)
	{
		ModelAndView view = new ModelAndView("update_data");
		Employee employee = service.updateEmploye(id);
		view.addObject("employee", employee);
		return view;
	}
	@RequestMapping("/delete/{id}")
	public String deleteEmp(@PathVariable(name = "id") int id)
	{
		service.deleteEmployee(id);
		return "redirect:/";
	}
}
