package com.lydiasystems.challenge.controller;

import com.lydiasystems.challenge.entity.Product;
import com.lydiasystems.challenge.service.PaymentServiceClients;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentServiceClients paymentServiceClients;

    @PostMapping()
    public ResponseEntity<String> processPayment(@RequestBody Product product) {
        //TODO - * Customers paying for the same product at the same time should not buy the product if the stock is depleted. (i.e. if there are 2 stocks left and 3 customers pay at the same time, first 2 successful should buy the product and the 3rd one should fail with an appropriate message.)
        paymentServiceClients.call(product.getPrice());
        return ResponseEntity.ok("Payment processing initiated");
    }
}
