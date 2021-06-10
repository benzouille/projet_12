package fr.banane.newsservice.news.web.controller;

import fr.banane.newsservice.news.entities.Communication;
import fr.banane.newsservice.news.entities.Medium;
import fr.banane.newsservice.news.exceptions.ObjectNotFoundException;
import fr.banane.newsservice.news.services.CommunicationMediumService;
//import fr.banane.newsservice.news.web.proxies.MailProxy;
import fr.banane.newsservice.news.web.proxies.MailProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CommunicationMediumRestController {

    //------------------------- ATTRIBUTS -------------------------

    private final CommunicationMediumService communicationMediumService;

    private final MailProxy mailProxy;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * Constructeur avec injection de dépendence
     * @param communicationMediumService
     * @param mailProxy
     */
    public CommunicationMediumRestController(CommunicationMediumService communicationMediumService, MailProxy mailProxy) {
        this.communicationMediumService = communicationMediumService;
        this.mailProxy = mailProxy;
    }

    //-----------------------------COMMUNICATION-----------------------------

    /**
     * Endpoint de renvoi d'un objet communication {@link Communication}
     * @param id integer
     * @return Optional<Communication>
     */
    @GetMapping(path = "/Communications/{id}")
    public Optional<Communication> getCommunication(@PathVariable int id) {
        log.info("appel du microservice news methode /communicationsTest");

        Optional<Communication> communication = communicationMediumService.findById(id);

        if (!communication.isPresent())
            throw new ObjectNotFoundException("La communication correspondant à l'id " + id + " n'existe pas");

        return communication;
    }

    /**
     * Endpoint de renvoi d'une liste objet communication {@link Communication}
     * @return List Communication
     */
    @GetMapping(path = "/Communications")
    public List<Communication> getAllCommunications() {
        log.info("appel du microservice news methode /Communications");
        return communicationMediumService.listCommunications();
    }

    /**
     * Endpoint de renvoi d'une liste objet communication ayant pour medium "SITE" {@link Communication}
     * @return List Communication
     */
    @GetMapping(path = "/CommunicationsForSite")
    public List<Communication> getAllCommunicationsForSite() {
        log.info("appel du microservice news methode /CommunicationsForSite");
        return communicationMediumService.loadCommunicationByMediumName("SITE");
    }

    /**
     * Endpoint de renvoi d'une liste objet communication ayant pour medium "SITE" pour la page d'accueil du site {@link Communication}
     * @return List Communication
     */
    @GetMapping(path = "/CommunicationsForMainPage")
    public List<Communication> getAllCommunicationsForMainPage() {
        log.info("appel du microservice news methode /CommunicationsForMainPage");
        return communicationMediumService.loadThirdCommunicationByMediumName("SITE");
    }

    /**
     * Endpoint de renvoi d'une liste objet communication ayant pour typeCom "ACTUALITE"{@link Communication}
     * @return List Communication
     */
    @GetMapping(path = "/Actualities")
    public List<Communication> getAllActualities() {
        log.info("appel du microservice news methode /Actualities");
        return communicationMediumService.loadCommunicationByTypeCom("ACTUALITE");
    }

    /**
     * Endpoint de renvoi d'une liste objet communication ayant pour typeCom "MANIFESTATION"{@link Communication}
     * @return List Communication
     */
    @GetMapping(path = "/Manfestations")
    public List<Communication> getAllManfestations() {
        log.info("appel du microservice news methode /Manfestations");
        return communicationMediumService.loadCommunicationByTypeCom("MANIFESTATION");
    }

    /**
     * Endpoint de renvoi d'une liste objet communication ayant pour typeCom "INFORMATION"{@link Communication}
     * @return List Communication
     */
    @GetMapping(path = "/Informations")
    public List<Communication> getAllInformations() {
        log.info("appel du microservice news methode /Informations");
        return communicationMediumService.loadCommunicationByTypeCom("INFORMATION");
    }

    /**
     * Endpoint de recuperation d'un objet communication {@link Communication}
     * @param communication {@link Communication}
     * @return ResponseEntity CREATED
     * @throws Exception
     */
    @PostMapping(path = "AddNews")
    public ResponseEntity<Communication> addNews(@RequestBody Communication communication) throws Exception {
        log.info("appel du microservice news methode /AddNews");

        Communication newCommunication = communicationMediumService.addNewCommunication(communication);

        if (newCommunication == null) throw new Exception("Impossible d'ajouter cette communication");

        return new ResponseEntity<Communication>(communication, HttpStatus.CREATED);
    }

    /**
     * Permet de mettre à jour une communication existante.
     * @param communication bean {@link Communication}
     **/
    @PutMapping(value = "/Communications")
    public void updateCommunication(@RequestBody Communication communication) {

        communicationMediumService.addNewCommunication(communication);
    }

    //-----------------------------MEDIUM-----------------------------

    @GetMapping(path = "/Mediums")
    public List<Medium> getMediums() {
        log.info("appel du microservice news methode /Mediums");
        return communicationMediumService.listMediums();
    }

    //-----------------------------INTERNAL-METHOD-----------------------------

    private ResponseEntity sendNewsLetterToMailService (){

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping(path = "/mail-test")
    String mailTest(){
        return mailProxy.mailTest();
    }
}
