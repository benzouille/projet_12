package fr.banane.newsservice.news.mapper;

import fr.banane.newsservice.news.dto.CommunicationDto;
import fr.banane.newsservice.news.dto.MailCommunicationDto;
import fr.banane.newsservice.news.entities.Communication;
import fr.banane.newsservice.news.entities.Medium;
import fr.banane.newsservice.news.services.CommunicationMediumService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Data
@Component
public class CommunicationMapper {

    CommunicationMediumService communicationMediumService;

    public CommunicationMapper(CommunicationMediumService communicationMediumService){
        this.communicationMediumService = communicationMediumService;
    }

    public Communication fromDto(CommunicationDto communicationDto) {
        Communication communication = new Communication();

        communication.setAuthor(communicationDto.getAuthor());
        communication.setTitle(communicationDto.getTitle());
        communication.setBody(communicationDto.getBody());
        communication.setTypeCom(communicationDto.getTypeCom());
        communication.setImagePath(communicationDto.getImagePath());
        communication.setDate(LocalDate.now());

        if (communicationDto.isOnDateEvent()) {
            communication.setDateEvent(communicationDto.getDate());
        }

        for (int i = 0; i < communicationDto.getMediumNames().length; i++) {
            Medium medium = communicationMediumService.loadMediumByMediumName(communicationDto.getMediumNames()[i]);
            communication.getMediums().add(medium);
        }

        return communication;
    }

    public MailCommunicationDto toMailDto(Communication communication){
        MailCommunicationDto mailCommunicationDto = new MailCommunicationDto();

        mailCommunicationDto.setTitle(communication.getTitle());
        mailCommunicationDto.setBody(communication.getBody());
        mailCommunicationDto.setImgPath("http://localhost:9101/image/"+communication.getImagePath());
        mailCommunicationDto.setLinkToSite("http://localhost:4200/news/communication/"+communication.getId());

        return mailCommunicationDto;
    }
}
