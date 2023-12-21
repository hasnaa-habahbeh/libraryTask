package com.example.LibraryTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/printBill")
    public Bill printBill(@RequestParam String customerName) {
        return paymentService.getBill(customerName);
    }

    @PostMapping("/addToBill/{customerName}/{bookName}")
    public String addToBill(@PathVariable String customerName, @PathVariable String bookName) {
        return paymentService.addToBill(customerName, bookName);
    }

    @PostMapping("/removeFromBill/{customerName}/{bookName}")
    public String removeFromBill(@PathVariable String customerName, @PathVariable String bookName) {
        return paymentService.removeFromBill(customerName, bookName);
    }
}
