package fr.banane.newsservice.news.web.proxies.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailListAndCommunication {

    //------------------------- ATTRIBUTS -------------------------

    private List<String> email;

    private String title;

    private String body;

    private String imgPath;

    private List<String> linkToOtherMedium;
}
