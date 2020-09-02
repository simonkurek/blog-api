package pl.szymonkurek.blogapi.deo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Article {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    
    private String desc;
    private String category;
    private String author;

    private String content;

    @ElementCollection
    private List<String> keywords;

    @OneToMany
    private List<Comment> comments;
}
