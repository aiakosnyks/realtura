package com.realtura.listingsservice.client.subscriptions.service;

import com.realtura.listingsservice.client.subscriptions.SubscriptionClient;
import com.realtura.listingsservice.dto.response.GenericResponse;
import com.realtura.listingsservice.model.Subscription;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class SubscriptionService {

    private final SubscriptionClient subscriptionClient;

    public Boolean useCredit(Long userId) {
        ResponseEntity<GenericResponse<?>> response = subscriptionClient.useCredit(userId);
        if (response == null || !HttpStatus.OK.equals(response.getStatusCode())) {
            assert response != null;
            log.error("Error Message: {}", response.getBody());
            return true;
        }
        return false;
    }

}

