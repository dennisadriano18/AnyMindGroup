package com.classes.myecommerce.controller;

import com.classes.myecommerce.model.*;
import com.classes.myecommerce.repository.PaymentInfoRepository;
import com.classes.myecommerce.service.UtilityService;
import com.classes.myecommerce.validation.Validation;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PaymentInfoController {
    private final PaymentInfoRepository paymentInfoRepository;

    public PaymentInfoController(PaymentInfoRepository paymentInfoRepository){
        this.paymentInfoRepository = paymentInfoRepository;
    }

    @QueryMapping
    Iterable<SearchResponse> findByDate(@Argument SearchRequest searchRequest){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<PaymentInfo> paymentInfoList = paymentInfoRepository.findByDateTimeBetween(LocalDateTime.parse(searchRequest.getStartDateTime(), formatter), LocalDateTime.parse(searchRequest.getEndDateTime(), formatter));
        List<SearchResponse> searchResponseList = new ArrayList<SearchResponse>();
        for(PaymentInfo paymentInfo : paymentInfoList){
            searchResponseList.add(new SearchResponse(paymentInfo.getDateTime().toString(),
                    paymentInfo.getPrice().toString(),
                    paymentInfo.getPoints().toString()));
        }
        return searchResponseList;
    }

    @MutationMapping
    PaymentResponse insertPaymentRecord(@Argument PaymentRequest paymentRequest){
        try {
        PaymentRequest request = new PaymentRequest(paymentRequest);
        PaymentInfo paymentInfo = new PaymentInfo(paymentRequest);
        Validation validation = new Validation(paymentInfo);
        UtilityService service = new UtilityService(paymentInfo);

            paymentInfo.setPoints(service.computePoints());
            paymentInfoRepository.save(paymentInfo);
            return new PaymentResponse(service.computeFinalPrice(), paymentInfo.getPoints());
        }catch(ParseException ex){

        }
        return new PaymentResponse();

    }
}
