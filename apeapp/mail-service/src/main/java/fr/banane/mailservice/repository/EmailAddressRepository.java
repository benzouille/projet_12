package fr.banane.mailservice.repository;

import fr.banane.mailservice.entities.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface EmailAddressRepository extends JpaRepository<EmailAddress, Long> {
    Optional<EmailAddress> findByEmailAddress(String email);

    boolean existsEmailAddressByEmailAddress(String email);
}
