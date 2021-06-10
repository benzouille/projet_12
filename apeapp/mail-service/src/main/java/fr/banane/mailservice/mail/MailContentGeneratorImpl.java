package fr.banane.mailservice.mail;

import fr.banane.mailservice.model.Communication;
import freemarker.core.ParseException;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Implementation de MailContentGenerator permetant de fusionner les données et le template du mail
 */
public class MailContentGeneratorImpl implements MailContentGenerator {

    private final Template template;

    public MailContentGeneratorImpl(final Configuration conf)
            throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException {
        super();
        template = conf.getTemplate("mailPrereservationDispo.ftl");
    }

    @Override
    public String generate(Communication communication) throws TemplateException, IOException {
        StringWriter sw = new StringWriter();
        template.process(communication, sw);
        return sw.toString();
    }
}
