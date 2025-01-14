package br.com.Lucas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Lucas.entity.Employee;
import br.com.Lucas.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> listAll() {
		return repository.findAll();
	}

	public void save(Employee e) {
		repository.save(e);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Employee get(Long id) {
		return repository.findById(id).get();
	}
}