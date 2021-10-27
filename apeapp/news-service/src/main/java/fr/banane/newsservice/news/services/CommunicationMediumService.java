package fr.banane.newsservice.news.services;

import fr.banane.newsservice.news.entities.Communication;
import fr.banane.newsservice.news.entities.Medium;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CommunicationMediumService {

    Optional<Communication> findById(long id);
    List<Communication> listCommunications();
    List<Communication> loadCommunicationByMediumName(String mediumName);
    List<Communication> loadCommunicationByTypeCom(String typeCom);
    List<Communication> loadCommunicationsBytitle(String title);
    Communication addNewCommunication(Communication communication);


    Medium addNewMedium(Medium medium);
    Medium loadMediumByMediumName(String mediumName);
    List<Medium> listMediums();

    void addMediumToCommunication(String mediumName, Long communicationId);



}
