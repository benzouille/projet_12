package fr.banane.mailservice.services;

import fr.banane.mailservice.repository.EmailAddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmailAddressServiceImpl implements EmailAddressService {

    private EmailAddressRepository emailAddressRepository;

    public EmailAddressServiceImpl(EmailAddressRepository emailAddressRepository){
        this.emailAddressRepository = emailAddressRepository;
    }


}
