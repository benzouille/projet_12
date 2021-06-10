package fr.banane.newsservice.news.web.proxies;

import fr.banane.newsservice.news.web.proxies.model.EmailListAndCommunication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Proxy du microservice mail.
 */
@FeignClient(name = "MAIL-SERVICE")
public interface MailProxy {

    @PostMapping(path = "/sendMailCommunication")
    ResponseEntity sendMailCommunication(@RequestBody EmailListAndCommunication emailListAndCommunication);

    @GetMapping(path = "/mail-test")
    String mailTest();

}
