package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService
{
	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public Iterable<Employee> getAllEmployee() {
		Iterable empList = empRepo.findAll(Sort.by("job").ascending());
		empList.forEach(System.out::println);
		return empRepo.findAll(Sort.by("job").ascending());
	}
	@Override
	public String insertEmployee(Employee emp) {
		return "EMPloyee inserted with "+empRepo.save(emp).getEmpno();
	}
	@Override
	public Employee getEmployeeByEno(int eno) {
		return empRepo.findById(eno).get();
	}
	@Override
	public String updateEmployee(Employee emp) {
		return "Record update with "+empRepo.save(emp).getEmpno();
	}
	@Override
	public String deleteEmployee(int eno) {
		empRepo.deleteById(eno);
		return eno+" Reocrd is deleted";
	}
	@Override
	public Page<Employee> getEmployeePageData(Pageable pageable) {
		return empRepo.findAll(pageable);
	}
}