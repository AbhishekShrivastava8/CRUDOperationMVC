package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.nt.model.Employee;

public interface IEmployeeRepo extends PagingAndSortingRepository<Employee, Integer>,JpaRepository<Employee, Integer>
{
	
}
