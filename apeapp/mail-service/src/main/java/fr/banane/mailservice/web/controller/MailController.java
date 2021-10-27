package fr.banane.mailservice.web.controller;

import fr.banane.mailservice.entities.EmailAddress;
import fr.banane.mailservice.mail.MailContentGenerator;
import fr.banane.mailservice.mail.MailContentGeneratorImpl;
import fr.banane.mailservice.mail.MailSenderService;
import fr.banane.mailservice.mail.MailSenderServiceImpl;
import fr.banane.mailservice.model.Communication;
import fr.banane.mailservice.repository.EmailAddressRepository;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@CrossOrigin
@RestController
public class MailController implements HealthIndicator {

    //------------------------- ATTRIBUTS -------------------------

    private MailContentGenerator mailContentGenerator;

    private MailSenderService mailSenderService;

    private EmailAddressRepository emailAddressRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private freemarker.template.Configuration config;

    public MailController (EmailAddressRepository emailAddressRepository){
        this.emailAddressRepository = emailAddressRepository;
    }

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

    @PostMapping(value = "/addMailAdress")
    public ResponseEntity addMailtoNewsletterList(@RequestBody String email){

        String pattern = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        String cleanEmail = email.split("\"")[3];

        Pattern patternEmail = Pattern.compile(pattern);
        Matcher matcher = patternEmail.matcher(cleanEmail);

        if(matcher.matches()){
            if(emailAddressRepository.existsEmailAddressByEmailAddress(cleanEmail)) {
                return new ResponseEntity("email adress already exist", HttpStatus.UNAUTHORIZED);
            }else{

                EmailAddress emailAdress = new EmailAddress();
                emailAdress.setEmailAddress(cleanEmail);
                emailAdress.setDateAdded(String.valueOf(LocalDate.now()));

                emailAddressRepository.save(emailAdress);

                return new ResponseEntity("email adress has been added",HttpStatus.CREATED);

            }
        }else{
            return new ResponseEntity("invalid email adress format", HttpStatus.UNAUTHORIZED);
        }
    }

    @PostMapping(value = "/delMailAdress")
    public ResponseEntity delMailtoNewsletterList(@RequestBody String mixedId){
        System.out.println("delete email by id : " + mixedId);
        String[] splitedString2 = mixedId.split("-");
        String cleanedId = splitedString2[3];

        Long emailId = Long.valueOf(cleanedId);

        Optional<EmailAddress> emailAddress = emailAddressRepository.findById(emailId);

        if(emailAddress.isPresent()){
            System.out.println("delete email by id : " + emailId);
//            emailAddressRepository.deleteById(emailId);

            return new ResponseEntity<>("email adress has been deleted",HttpStatus.OK);
        }else{
            return new ResponseEntity<>("there no such email address on your database",HttpStatus.NOT_ACCEPTABLE);
        }
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
            List<EmailAddress> emailList = emailAddressRepository.findAll();

            for(EmailAddress email : emailList){

                String unsubMaillingList = email.getDateAdded();
                unsubMaillingList += "-"+ email.getId();
                //mise en base64
                communication.setUnSubMailingList(Base64.getEncoder().encodeToString(unsubMaillingList.getBytes()));
                System.out.println("communication : " + communication.toString());
                String content = mailContentGenerator.generate(communication);
                mailSenderService.send(email.getEmailAddress(), communication.getTitle(), content);
                communication.setUnSubMailingList(null);
            }

        } catch (IOException | TemplateException | MessagingException e) {
            e.printStackTrace();
        }

        log.info("sendMailCommunication : " + communication.getTitle());

        return new ResponseEntity("mail send",HttpStatus.CREATED);
    }
}
