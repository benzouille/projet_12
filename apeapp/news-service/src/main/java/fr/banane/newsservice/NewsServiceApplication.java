package fr.banane.newsservice;

import fr.banane.newsservice.news.entities.Communication;
import fr.banane.newsservice.news.entities.Medium;
import fr.banane.newsservice.news.services.CommunicationMediumService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.util.ArrayList;

@SpringBootApplication
@EnableFeignClients
public class NewsServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsServiceApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/files/upload").allowedOrigins("http://localhost:4200");
				registry.addMapping("/files/**").allowedOrigins("http://localhost:4200");
				registry.addMapping("/image/**").allowedOrigins("**");
			}
		};
	}

	@Bean
	CommandLineRunner start(CommunicationMediumService communicationMediumService) {
		return args -> {

			communicationMediumService.addNewMedium(new Medium(null, "FACEBOOK"));
			communicationMediumService.addNewMedium(new Medium(null, "MAIL"));
			communicationMediumService.addNewMedium(new Medium(null, "SITE"));

			communicationMediumService.addNewCommunication(new Communication(null,"noel-20-12-20" , LocalDate.now(), "MANIFESTATION", new ArrayList<>(), "Noel","blablabla","la banane", "test.png"));
			communicationMediumService.addNewCommunication(new Communication(null,"photo-de-classe-16-09-20", LocalDate.now(), "ACTUALITE", new ArrayList<>(), "Photo de classe","blablabla","la fraise", "ben.jpg"));
			communicationMediumService.addNewCommunication(new Communication(null,"pâques-18-03-20", LocalDate.now(), "MANIFESTATION", new ArrayList<>(), "Pâques","blablabla","la framboise", "ben2_mini.jpg"));
			communicationMediumService.addNewCommunication(new Communication(null,"renouvellement-cotisation-03-09-20", LocalDate.now(), "INFORMATION", new ArrayList<>(), "renouvellement cotisation","blablabla","la banane", "64px-Skull_and_crossbones.svg.png"));
			communicationMediumService.addNewCommunication(new Communication(null, "retrait-chocolat-paques-01-04-21", LocalDate.now(), "INFORMATION", new ArrayList<>(), "COMMANDES DE CHOCOLATS", "Le retrait des commandes de chocolats de Pâques est prévu sous forme de « drive piéton » au nouveau local de l’APE (porte avant de l’ancienne école de Koenigsmacker située 1, rue du Père Scheil), dans le respect des règles sanitaires. Nous comptons sur vous pour respecter scrupuleusement les gestes barrières (port du masque obligatoire, distances à respecter…). \n" +
					"Les permanences sont les suivantes :\n" +
					"- Jeudi 1er avril : 16h-18h\n" +
					"- Vendredi 2 avril : 10h-12h et 14h-16h\n" +
					"- Samedi 3 avril : 10h12h et 14h-16h \n" +
					"Bon week-end à tous et à bientôt !", "La banane", null));


			communicationMediumService.addMediumToCommunication("FACEBOOK", 1L);
			communicationMediumService.addMediumToCommunication("MAIL", 1L);
			communicationMediumService.addMediumToCommunication("SITE", 1L);
			communicationMediumService.addMediumToCommunication("FACEBOOK", 2L);
			communicationMediumService.addMediumToCommunication("SITE", 2L);
			communicationMediumService.addMediumToCommunication("MAIL", 3L);
			communicationMediumService.addMediumToCommunication("SITE", 3L);
			communicationMediumService.addMediumToCommunication("SITE", 4L);
			communicationMediumService.addMediumToCommunication("SITE", 5L);
		};
	}

}
