package fr.banane.newsservice.news.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailCommunicationDto {

    //------------------------- ATTRIBUTS -------------------------

    private String title;

    private String body;

    private String imgPath;

    private String linkToSite;
}
