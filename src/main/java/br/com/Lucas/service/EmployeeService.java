package br.com.Lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Lucas.entity.Employee;
import br.com.Lucas.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired

	private EmployeeRepository repo;

	public List<Employee> listAll() {
		return repo.findAll();
	}

	public void save(Employee e) {
		repo.save(e);
	}

	public void delete(Long id) {
		repo.deleteById(id);

	}

	public Employee get(Long id) {
		return repo.findById(id).get();
		
	}
}
