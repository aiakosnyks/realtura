package com.realtura.realturamain.service;

import com.realtura.realturamain.client.user.service.UserService;
import com.realtura.realturamain.dto.request.SubscriptionSaveRequest;
import com.realtura.realturamain.model.Product;
import com.realtura.realturamain.model.Subscription;
import com.realtura.realturamain.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Service
public class SubscriptionService {

    private final UserService userService;
    private final SubscriptionRepository subscriptionRepository;
    private final Product product;

    private boolean processPayment(Long userId, double amount, Integer productQuantity) {

        if(amount == product.getPrice() * productQuantity) {
            log.info("Processing payment for user: " + userId + ", amount: " + amount);
            return true;
        }
        log.error("Processing payment for user: " + userId + " FAILED");
        return false;
    }

    public void purchasePackage(SubscriptionSaveRequest request) {

        Long userId = request.getUserId();
        double amount = request.getAmount();
        Integer productQuantity = request.getProductQuantity();

        if (!userService.getUserById(userId).isPresent()) {
            log.error("User " + userId + " not found");
            throw new RuntimeException("User not found");
        }

        if (processPayment(userId, amount, productQuantity)) {
            Optional<Subscription> optionalSubscription = subscriptionRepository.findByUserId(userId);
            if (optionalSubscription.isPresent()) {
                Subscription subscription = optionalSubscription.get();
                Integer newCredits = subscription.getCredits() + productQuantity;
                Integer daysToAdd = productQuantity * product.getSubscriptionDuration().getDays();
                Period extendedPeriod = Period.ofDays(daysToAdd);
                subscription.setSubscriptionDuration(extendedPeriod);
                subscription.setSubscribedUntil(subscription.getSubscribedUntil().plusDays(daysToAdd));
                subscriptionRepository.save(subscription);
                log.info("Subscription extended for user: " + userId + ", new subscription duration: " + extendedPeriod);
            } else {
                Subscription subscription = new Subscription(userId);
                subscription.setCredits(product.getCredits());
                subscription.setSubscriptionDuration(product.getSubscriptionDuration());
                subscription.setSubscribedUntil(LocalDateTime.now().plusDays(product.getSubscriptionDuration().getDays()));
                subscriptionRepository.save(subscription);
                log.info("Subscription created for user: " + userId);
            }
        } else {
            throw new RuntimeException("Payment failed");
        }
    }

    public Subscription getSubscriptionsByUserId(Long userId) {
        return subscriptionRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Subscription not found for user: " + userId));
    }
}



