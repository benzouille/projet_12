package fr.banane.newsservice.news.services;

import fr.banane.newsservice.news.entities.Communication;
import fr.banane.newsservice.news.entities.Medium;
import fr.banane.newsservice.news.repository.CommunicationRepository;
import fr.banane.newsservice.news.repository.MediumRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommunicationMediumServiceImpl implements CommunicationMediumService {

    private CommunicationRepository communicationRepository;

    private MediumRepository mediumRepository;

    public CommunicationMediumServiceImpl(CommunicationRepository messageRepository, MediumRepository mediumRepository) {
        this.communicationRepository = messageRepository;
        this.mediumRepository = mediumRepository;
    }

    @Override
    public Communication addNewCommunication(Communication communication) {
        communicationRepository.save(communication);
        return communication;
    }

    @Override
    public Optional<Communication> findById(long id) {
        return communicationRepository.findById(id);
    }

    @Override
    public List<Communication> loadCommunicationsBytitle(String title) {

        return communicationRepository.findAllByTitle(title);
    }

    @Override
    public List<Communication> listCommunications() {
        return communicationRepository.findAll();
    }

    @Override
    public List<Communication> loadCommunicationByMediumName(String mediumName){ return communicationRepository.findAllByMediumsName(mediumName); }

    @Override
    public List<Communication> loadCommunicationByTypeCom(String typeCom) { return communicationRepository.findAllByTypeCom(typeCom); }

    @Override
    public Medium addNewMedium(Medium medium) {
        return mediumRepository.save(medium);
    }

    @Override
    public Medium loadMediumByMediumName(String mediumName) {
        return mediumRepository.getByMediumName(mediumName);
    }

    @Override
    public List<Medium> listMediums() {
        return mediumRepository.findAll();
    }

    @Override
    public void addMediumToCommunication(String mediumName, Long communicationId) {
        Medium medium = mediumRepository.getByMediumName(mediumName);
        Optional<Communication> communication = communicationRepository.findById(communicationId);
        communication.get().getMediums().add(medium);
    }
}
