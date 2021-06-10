package fr.banane.mailservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * POJO des données du mail a envoyer
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class Communication {

    //------------------------- ATTRIBUTS -------------------------

    private List<String> email;

    private String title;

    private String body;

    private String imgPath;

    private List<String> linkToOtherMedium;

}
