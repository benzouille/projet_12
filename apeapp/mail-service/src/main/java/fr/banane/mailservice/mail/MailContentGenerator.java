package fr.banane.mailservice.mail;

import fr.banane.mailservice.model.Communication;
import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * Interface Generateur mail
 */
public interface MailContentGenerator {

    String generate(Communication communication) throws TemplateException, IOException;
}
