package fr.banane.mailservice.web.controller;

import fr.banane.mailservice.mail.MailContentGenerator;
import fr.banane.mailservice.mail.MailContentGeneratorImpl;
import fr.banane.mailservice.mail.MailSenderService;
import fr.banane.mailservice.mail.MailSenderServiceImpl;
import fr.banane.mailservice.model.Communication;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class MailController implements HealthIndicator {

    //------------------------- ATTRIBUTS -------------------------

    private MailContentGenerator mailContentGenerator;

    private MailSenderService mailSenderService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private freemarker.template.Configuration config;

    Logger log = LoggerFactory.getLogger(this.getClass());

    //------------------------- METHODE -------------------------

    /**
     * Indique le status du microservice
     *
     * @return etat du microservice
     */
    @Override
    public Health health() {

        if (1+1 != 2) {
            return Health.down().build();
        }
        return Health.up().build();
    }

    @GetMapping(path = "/mail-test")
    public String mailTest(){
        String retour = "Ceci est le retour de mail-test du micro service mail";

        return retour;
    }

    /**
     * Envoyer un email
     *
     * @param communication bean {@link Communication}
     * @return ResponseEntity Reservation renvoi un http status.
     */
    @PostMapping(value = "/sendMailCommunication")
    public ResponseEntity sendMailCommunication(@RequestBody Communication communication) {

        try {
            mailContentGenerator = new MailContentGeneratorImpl(config);
            mailSenderService = new MailSenderServiceImpl(javaMailSender);

            String content = mailContentGenerator.generate(communication);

            for(String email : communication.getEmail()){
                mailSenderService.send(email, communication.getTitle(), content);
            }

        } catch (IOException | TemplateException | MessagingException e) {
            e.printStackTrace();
        }

        log.info("sendMailCommunication : " + communication.getTitle());

        return new ResponseEntity("mail send",HttpStatus.CREATED);
    }
}
