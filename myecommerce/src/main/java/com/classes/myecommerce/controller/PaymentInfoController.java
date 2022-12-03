package com.classes.myecommerce.controller;

import com.classes.myecommerce.model.PaymentInfo;
import com.classes.myecommerce.repository.PaymentInfoRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PaymentInfoController {
    private final PaymentInfoRepository paymentInfoRepository;

    public PaymentInfoController(PaymentInfoRepository paymentInfoRepository){
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @MutationMapping
    PaymentInfo createPaymentInfo(@Argument PaymentInfo paymentInfoInput){
        PaymentInfo paymentInfo = new PaymentInfo(paymentInfoInput.getCustomerId(), paymentInfoInput.getPrice(), paymentInfoInput.getPriceModifier(), paymentInfoInput.getDateTime(), paymentInfoInput.getPaymentMethod());
        return paymentInfoRepository.save(paymentInfo);
    }
}
