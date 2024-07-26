package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeMgmtService;
import com.nt.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	@Autowired
	private IEmployeeMgmtService service;
	@Autowired
	private EmployeeValidator validator;

	@RequestMapping("/")
	public String showHomePage() {
		return "home";
	}

//	@GetMapping("/emp_report")
//	public String showEmployeeReport(Map<String, Object> map) {
//		Iterable<Employee> empList = service.getAllEmployee();
//		map.put("empList", empList);
//		return "employee_report";
//	}
	@GetMapping("/emp_report")
	public String showEmployeeReport(@PageableDefault(size = 3, page = 0, sort = "job", direction = Direction.ASC) Pageable pageable ,Map<String, Object> map) {
//		Iterable<Employee> empList = service.getAllEmployee();
		Page page = service.getEmployeePageData(pageable);
		map.put("pageData", page);
		return "employee_report";
	}

	@GetMapping("/insert_employee")
	public String showEmployeeForm(@ModelAttribute("emp") Employee emp) {
		return "add_employee";
	}

	@PostMapping("/insert_employee")
	public String insertEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		if (emp.getVflag().equalsIgnoreCase("no")) {
			if (validator.supports(emp.getClass())) {
				validator.validate(emp, errors);
				if (errors.hasErrors())
					return "add_employee";
			}
		}
		if (emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			errors.rejectValue("job", "e.job.restriction");
			return "add_employee";
		}
		String result = service.insertEmployee(emp);
		attrs.addFlashAttribute("result", result);
		return "redirect:emp_report";
	}

	@GetMapping("edit_employee")
	public String editEmployee(@RequestParam("eno") int eno, @ModelAttribute("emp") Employee emp) {
		Employee emp1 = service.getEmployeeByEno(eno);
		BeanUtils.copyProperties(emp1, emp);
		return "modify_employee";
	}

	@PostMapping("/edit_employee")
	public String editEmployee(RedirectAttributes attrs, @ModelAttribute("emp") Employee emp, BindingResult errors) {
		if (emp.getVflag().equalsIgnoreCase("no")) {
			if (validator.supports(emp.getClass())) {
				validator.validate(emp, errors);
				if (errors.hasErrors())
					return "modify_employee";
			}
		}
		if (emp.getJob().equalsIgnoreCase("PRESIDENT") || emp.getJob().equalsIgnoreCase("QUEEN")) {
			errors.rejectValue("job", "e.job.restriction");
			return "modify_employee";
		}
		String result = service.updateEmployee(emp);
		Iterable<Employee> empList = service.getAllEmployee();
		attrs.addFlashAttribute("result", result);
		attrs.addFlashAttribute("empList", empList);
		return "redirect:emp_report";
	}

	@GetMapping("/delete_employee")
	public String deleteEmployee(@RequestParam("eno") int eno, RedirectAttributes attrs) {
		String result = service.deleteEmployee(eno);
		Iterable<Employee> empList = service.getAllEmployee();
		attrs.addFlashAttribute("empList", empList);
		attrs.addFlashAttribute("result", result);
		return "redirect:emp_report";
	}
}