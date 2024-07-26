package com.nt.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nt.model.Employee;

public interface IEmployeeMgmtService {

	public Iterable<Employee> getAllEmployee();
	public Page<Employee> getEmployeePageData(Pageable pageable);
	public String insertEmployee(Employee emp);
	public Employee getEmployeeByEno(int eno);
	public String updateEmployee(Employee emp);
	public String deleteEmployee(int eno);
}
