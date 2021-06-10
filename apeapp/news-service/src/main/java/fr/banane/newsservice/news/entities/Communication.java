package fr.banane.newsservice.news.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor  @AllArgsConstructor
public class Communication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    private LocalDate date;

    private String typeCom;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Medium> mediums = new ArrayList<>();

    @Length(max = 300)
    private String title;

    @Length(max = 3000)
    private String body;

    private String author;

    private String imagePath;
}
