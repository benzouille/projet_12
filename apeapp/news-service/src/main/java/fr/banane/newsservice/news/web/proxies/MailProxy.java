package fr.banane.newsservice.news.web.proxies;

import fr.banane.newsservice.news.web.proxies.model.EmaiListAndCommunication;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Proxy du microservice mail.
 */
@FeignClient(name = "mail-service", url = "localhost:9601")
public interface MailProxy {

    @PostMapping(path = "/sendMailCommunication")
    ResponseEntity sendMailCommunication(@RequestBody EmaiListAndCommunication emaiListAndCommunication);

    @GetMapping(path = "/mail-test")
    String mailTest();
}
