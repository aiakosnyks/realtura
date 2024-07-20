package com.realtura.realturamain.controller;

import com.realtura.realturamain.dto.request.SubscriptionSaveRequest;
import com.realtura.realturamain.model.Subscription;
import com.realtura.realturamain.service.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping
    public void save(@RequestBody SubscriptionSaveRequest request) {
        subscriptionService.purchasePackage(request);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Subscription> getSubscriptionByUserId(@PathVariable Long userId) {
        Subscription subscription= subscriptionService.getSubscriptionsByUserId(userId);
        return ResponseEntity.ok(subscription);
    }
}