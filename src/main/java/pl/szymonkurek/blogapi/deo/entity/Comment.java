package pl.szymonkurek.blogapi.deo.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;
    private String email;
    private String content;
}
