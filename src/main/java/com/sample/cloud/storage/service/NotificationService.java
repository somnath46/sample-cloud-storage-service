package com.sample.cloud.storage.service;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {

    @Value("${application.topic.name}")
    private String topicArn;
    private final AmazonSNSClient snsClient;
    public String addSubscription(String email) {
        SubscribeRequest request = new SubscribeRequest(topicArn, "email", email);
        snsClient.subscribe(request);
        return "Subscription request is pending. To confirm the subscription, check your email : " + email;
    }

    @Async
    public String publishMessageToTopic(final String uploadedFileName){
        PublishRequest publishRequest=new PublishRequest(topicArn,buildEmailBody(uploadedFileName),"Notification: Network connectivity issue");
        snsClient.publish(publishRequest);
        log.info("Notification send successfully !!");
        return "Notification send successfully !!";
    }

    private String buildEmailBody(final String uploadedFileName){
        return "Dear Employee ,\n" +
                "\n" +
                "\n" +
                "File " + uploadedFileName + " successfully uploaded"+"\n";
    }
}
