package fr.banane.mailservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * POJO des données du mail a envoyer
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Communication {

    //------------------------- ATTRIBUTS -------------------------

    private String title;

    private String body;

    private String imgPath;

    private String linkToSite;

    private String unSubMailingList;

}
