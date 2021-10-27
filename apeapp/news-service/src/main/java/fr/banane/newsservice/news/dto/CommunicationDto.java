package fr.banane.newsservice.news.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommunicationDto {

    String typeCom;
    boolean onDateEvent;
    LocalDate date;
    String[] mediumNames;
    String body;
    String imagePath;
    String title;
    String author;
}
