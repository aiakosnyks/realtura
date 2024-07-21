package com.realtura.realturamain.controller;

import com.realtura.realturamain.dto.request.SubscriptionSaveRequest;
import com.realtura.realturamain.dto.response.CreateResponse;
import com.realtura.realturamain.dto.response.GenericResponse;
import com.realtura.realturamain.model.Subscription;
import com.realtura.realturamain.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public ResponseEntity<GenericResponse<CreateResponse>> save(@RequestBody SubscriptionSaveRequest request) {
        return new ResponseEntity<>(subscriptionService.purchasePackage(request), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Subscription> getSubscriptionByUserId(@PathVariable Long userId) {
        Subscription subscription= subscriptionService.getSubscriptionsByUserId(userId);
        return ResponseEntity.ok(subscription);
    }
}