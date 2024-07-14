package com.example.accounts.service.client;

import com.example.accounts.dto.LoanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "loans", fallback = LoansFallback.class)
public interface LoansFeignClient {

    @GetMapping(value = "/loans/fetch", consumes = "application/json")
    ResponseEntity<LoanDto> fetchLoan(@RequestHeader("nakoual-correlation-id") String correlationId, @RequestParam String mobileNumber);
}