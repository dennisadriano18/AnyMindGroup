package com.classes.myecommerce.repository;

import com.classes.myecommerce.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {

    List<PaymentInfo> findByDateTimeBetween(LocalDateTime dateTimeStart, LocalDateTime dateTimeEnd);
}
