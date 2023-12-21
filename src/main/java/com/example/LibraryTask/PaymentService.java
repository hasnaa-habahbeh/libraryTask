package com.example.LibraryTask;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@AllArgsConstructor
@Service
public class PaymentService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private BookRepository bookRepository;

    public Bill getBill(String customerName) {
        Customer customer = customerRepository.findByName(customerName);

        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        return customer.getBill();
    }

    public String addToBill(String customerName, String bookName) {
        Customer customer = customerRepository.findByName(customerName);
        Book book = bookRepository.findByTitle(bookName);

        if (customer == null || book == null) {
            throw new RuntimeException("Either customer or book not found");
        }

        int updatedBookQuantity = book.getQuantity() - 1;
        if (updatedBookQuantity < 0) {
            throw new RuntimeException("We don't have this book in stock!");
        }

        Bill bill = customer.getBill();

        if (bill == null) {
            bill = new Bill(0, new ArrayList<>());
            customer.setBill(bill);
        }

        book.setQuantity(updatedBookQuantity);
        bookRepository.save(book);

        bill.getBooks().add(book);

        double updatedTotalPrice = bill.getTotalPrice() + book.getPrice();
        bill.setTotalPrice(updatedTotalPrice);
        billRepository.save(bill);

        customer.setBill(bill);
        customerRepository.save(customer);

        return "Added book to bill and customer bill has been updated" + bill;
    }

    public String removeFromBill(String customerName, String bookName) {
        Customer customer = customerRepository.findByName(customerName);
        Book book = bookRepository.findByTitle(bookName);

        if (customer == null || book == null) {
            throw new RuntimeException("Either customer or book not found");
        }

        Bill bill = customer.getBill();

        if (bill == null) {
            throw new RuntimeException("Bill not found");
        }

        if (!bill.getBooks().contains(book)) {
            throw new RuntimeException("Book doesn't exist in the customer's bill");
        }

        bill.getBooks().remove(book);

        int updatedBookQuantity = book.getQuantity() + 1;
        book.setQuantity(updatedBookQuantity);
        bookRepository.save(book);

        double updatedTotalPrice = bill.getTotalPrice() - book.getPrice();
        bill.setTotalPrice(updatedTotalPrice);
        billRepository.save(bill);

        customer.setBill(bill);
        customerRepository.save(customer);

        return "Removed book form bill and updated customer bill" + bill;
    }
}
