package fr.banane.newsservice.news.repository;

import fr.banane.newsservice.news.entities.Communication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CommunicationRepository extends JpaRepository<Communication, Long> {

    List<Communication> findAllByTitle(String title);

    @Query(value = "SELECT * FROM COMMUNICATION WHERE TYPE_COM = :TYPE_COM", nativeQuery = true)
    List<Communication> findAllByTypeCom(@Param("TYPE_COM") String typeCom);

    @Query(value = "SELECT * FROM COMMUNICATION INNER JOIN communication_mediums ON communication_mediums.communication_id = communication.id INNER JOIN medium ON communication_mediums.mediums_id = medium.id WHERE medium_name =:mediumName", nativeQuery = true)
    List<Communication> findAllByMediumsName(@Param("mediumName")String mediumName);

    @Query(value = "SELECT * FROM COMMUNICATION INNER JOIN communication_mediums ON communication_mediums.communication_id = communication.id INNER JOIN medium ON communication_mediums.mediums_id = medium.id WHERE medium_name =:mediumName order by communication.id desc limit 3", nativeQuery = true)
    List<Communication> findThirdByMediumName(@Param("mediumName")String mediumName);

}
