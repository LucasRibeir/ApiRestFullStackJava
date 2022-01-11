package br.com.Lucas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Lucas.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
