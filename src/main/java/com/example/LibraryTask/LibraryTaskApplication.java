package com.example.LibraryTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.boot.CommandLineRunner;
//
//import java.util.ArrayList;

@SpringBootApplication
public class LibraryTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryTaskApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner(AuthorRepository authorRepository, BookRepository bookRepository) {
//		return args -> {
//			Author beanAuthor = new Author("Hala Azmi");
//
//			authorRepository.insert(beanAuthor);
//
//			bookRepository.insert(new Book("The Secret", true, 20, 40, beanAuthor));
//			bookRepository.insert(new Book("The Other Secret", false, 10, 30, beanAuthor));
//		};
//	}

//	@Bean
//	CommandLineRunner runner(CustomerRepository customerRepository, BillRepository billRepository, BookRepository bookRepository) {
//		return args -> {
//			Book bookToAdd = bookRepository.findByTitle("The Secret");
//
//			Bill beanBill = new Bill(40, new ArrayList<>());
//			beanBill.getBooks().add(bookToAdd);
//
//			billRepository.insert(beanBill);
//
//			Customer beanCustomer = new Customer("Hasnaa", beanBill);
//			customerRepository.insert(beanCustomer);
//		};
//	}
}
