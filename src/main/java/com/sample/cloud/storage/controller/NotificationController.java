package com.sample.cloud.storage.controller;

import com.sample.cloud.storage.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notify")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;
    @PostMapping("/subscription/{email}")
    public String addSubscription(@PathVariable String email) {
        notificationService.addSubscription(email);
        return "Subscription request is pending. To confirm the subscription, check your email : " + email;
    }
}
