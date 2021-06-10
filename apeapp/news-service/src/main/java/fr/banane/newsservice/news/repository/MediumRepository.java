package fr.banane.newsservice.news.repository;

import fr.banane.newsservice.news.entities.Medium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MediumRepository extends JpaRepository<Medium,Long> {
    Medium getByMediumName(String mediumName);
}
