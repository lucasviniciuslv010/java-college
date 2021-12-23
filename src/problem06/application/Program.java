package problem06.application;

import java.util.ArrayList;
import java.util.List;

import problem06.model.entities.Employee;
import problem06.model.entities.Product;
import problem06.model.util.CalculationService;

/*
Uma empresa de consultoria deseja avaliar a performance de produtos,
funcionários, dentre outras coisas. Um dos cálculos que ela precisa é encontrar
o maior dentre um conjunto de elementos. Fazer um programa que informe qual é o maior
elemento de uma coleção qualquer.
*/

public class Program {

	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Thiago Silva", 1700.00));
		employees.add(new Employee("Renata Cavalcante", 997.00));
		employees.add(new Employee("Lucas Vinicius", 3400.00));
		employees.add(new Employee("Bruna Silva", 2300.00));
		employees.add(new Employee("Renan Algusto", 4600.00));
		employees.add(new Employee("Rafaela Santos", 3800.00));
		
		List<Product> products = new ArrayList<>();
		products.add(new Product("TV", 1300.90));
		products.add(new Product("Iphone 11", 5300.00));
		products.add(new Product("Notebook Asus", 3400.90));
		products.add(new Product("Samsung S20", 4199.90));
		products.add(new Product("PlayStation 5", 5000.90));
		
		// Collections.max(); 
		System.out.println("Highest salary: " + CalculationService.max(employees));
		System.out.println("Most expensive product: " + CalculationService.max(products));
		
	}

}